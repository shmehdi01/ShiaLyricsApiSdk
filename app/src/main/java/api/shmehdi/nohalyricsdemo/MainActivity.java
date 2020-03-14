package api.shmehdi.nohalyricsdemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import api.shmehdi.shialyricsapi.LyricsApi;
import api.shmehdi.shialyricsapi.ShiaLyricsApi;
import api.shmehdi.shialyricsapi.annotation.ApiFormat;
import api.shmehdi.shialyricsapi.annotation.ApiQuery;
import api.shmehdi.shialyricsapi.annotation.ApiType;
import api.shmehdi.shialyricsapi.models.Artist;
import api.shmehdi.shialyricsapi.models.Lyrics;
import api.shmehdi.shialyricsapi.models.SearchResult;
import api.shmehdi.shialyricsapi.models.Title;
import api.shmehdi.shialyricsapi.models.Year;

public class MainActivity extends AppCompatActivity implements LyricsApi.Loader, LyricsApi.ErrorListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getArtist();
        searchCount("Nadeem");
        searchLyrics("Nadeem");

    }

    @Override
    public void onLoading(boolean isLoading) {
        //Handle Loader
    }

    @Override
    public void onError(String errorMsg, int errorCode) {
        //Handle Api Error
    }


    public void getArtist() {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi.Builder()
                .setFormat(ApiFormat.JSON)
                .setQuery(ApiQuery.NAUHAKHAN)
                .setType(ApiType.NAUHA) //GET Artist For Nauha, Manqabat, Marsiya
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getArtist(new LyricsApi.ApiResponse<List<Artist>>() {
            @Override
            public void onResponse(List<Artist> artists) {
                //Do What You Want
                Log.d(TAG, "RESPONSE_ARTIST: " + artists.size() );

                //getYear(artists.get(9));
            }
        });
    }

    public void getYear(final Artist artist) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setFormat(ApiFormat.JSON)
                .setType(ApiType.NAUHA) //GET Year For Nauha, Manqabat, Marsiya
                .setQuery(ApiQuery.YEAR)
                .setLoader(this)
                .setErrorListener(this)
                .setId(artist.getId())
                .createApi();

        shiaLyricsApi.getYears(new LyricsApi.ApiResponse<List<Year>>() {
            @Override
            public void onResponse(List<Year> years) {
                //do
                Log.d(TAG, "RESPONSE_YEAR: " + years.size() );

                //getTitle(artist,years.get(0));
            }
        });
    }

    public void getTitle(Artist artist, Year year) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setFormat(ApiFormat.JSON)
                .setType(ApiType.NAUHA) //GET Title For Nauha, Manqabat, Marsiya
                .setQuery(ApiQuery.LIST)
                .setId(artist.getId())
                .setYear(year.getYear())
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getTitles(new LyricsApi.ApiResponse<List<Title>>() {
            @Override
            public void onResponse(List<Title> titles) {
                //do
                Log.d(TAG, "RESPONSE_TITLES: " + titles.size() );

                //getLyrics(titles.get(0));
            }
        });
    }

    public void getLyrics(Title title) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setType(ApiType.NAUHA) //GET Lyrics For Nauha, Manqabat, Marsiya
                .setQuery(ApiQuery.LYRICS)
                .setId(title.getId())
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getLyrics(new LyricsApi.ApiResponse<Lyrics>() {
            @Override
            public void onResponse(Lyrics lyrics) {
                //do
                Log.d(TAG, "RESPONSE_LYRICS: " + lyrics.getLyrics() );
            }
        });
    }

    public void searchLyrics(String keyword) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setFormat(ApiFormat.JSON)
                .setQuery(ApiQuery.SEARCH)
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getSearch(keyword, new LyricsApi.ApiResponse<List<SearchResult>>() {
            @Override
            public void onResponse(List<SearchResult> searchResults) {
                //do
                Log.d(TAG, "RESPONSE_SEARCH: " + searchResults.size() );
            }
        });
    }

    public void searchCount(String keywords) {
        ShiaLyricsApi shiaLyricsApi = new LyricsApi
                .Builder()
                .setQuery(ApiQuery.SEARCH_COUNT)
                .setLoader(this)
                .setErrorListener(this)
                .createApi();

        shiaLyricsApi.getSearchCount(keywords, new LyricsApi.ApiResponse<String>() {
            @Override
            public void onResponse(String count) {
                //do
                Log.d(TAG, "RESPONSE_SEARCH_COUNT: " + count);
            }
        });
    }

}
