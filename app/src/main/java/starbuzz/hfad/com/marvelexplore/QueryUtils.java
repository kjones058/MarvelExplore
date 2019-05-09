package starbuzz.hfad.com.marvelexplore;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class QueryUtils extends NetworkUtils {

    private QueryUtils() {
    }


    public static Pair<ArrayList<Character>, Integer> extractCharacters(String JSONResponse) {

        ArrayList<Character> characters = new ArrayList<>();
        Integer total = 0;
        try {
            JSONObject jsonObject = new JSONObject(JSONResponse);
            JSONObject mainObject = jsonObject.getJSONObject("data");
            JSONArray results = mainObject.getJSONArray("results");
            total = mainObject.getInt("total");
            for (int i = 0; i < results.length(); i++) {
                JSONObject curr = results.getJSONObject(i);
                int id = curr.getInt("id");
                String name = curr.getString("name");
                String descrp = curr.getString("description");
                JSONObject image = curr.getJSONObject("thumbnail");
                String imageUrl = image.getString("path") + "." + image.getString("extension");
                Bitmap imageBitmap = getBitmapFromURL(imageUrl);
                Character character = new Character(name, id, descrp, imageBitmap);
                characters.add(character);
            }
        } catch (JSONException e) {

            Log.e("character JSON", "Problem parsing the character JSON results", e);
        }

        return new Pair<>(characters, total);
    }

    public static String getMD5Hash(String timeStamp) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((timeStamp + SECRET_KEYS.PRIVATE_KEY + SECRET_KEYS.PUBLIC_KEY).getBytes());
            byte[] byteData = messageDigest.digest();
            for (byte single : byteData) {
                sb.append(Integer.toString((single & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("Characters", "MD5 hash didn't work");
        }
        return sb.toString();
    }



}