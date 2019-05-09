package starbuzz.hfad.com.marvelexplore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CharacterAdpater extends ArrayAdapter {

    private Context mContext;
    public CharacterAdpater(Context context, ArrayList<Character> characters) {
        super(context, 0, characters);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.character_item, parent, false);
        }
        final Character character = (Character) getItem(position);
        ImageView image =  listItemView.findViewById(R.id.character_image);
        TextView charName =  listItemView.findViewById(R.id.character_name);


        TextView charDescrp =  listItemView.findViewById(R.id.character_description);
        if(!((Character) getItem(position)).wasClicked()) {
            charDescrp.setMaxLines(3);

        }
        else {
            charDescrp.setMaxLines(20);
        }
        image.setImageBitmap(character.getImage());
        charName.setText(character.getCharName());
        charDescrp.setText(character.getDecrp());
        return listItemView;
    }
}
