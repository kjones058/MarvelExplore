package starbuzz.hfad.com.marvelexplore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelUniverseAPI {

  @GET("characters")
    Call<List<Character>> getCharacters();
}
