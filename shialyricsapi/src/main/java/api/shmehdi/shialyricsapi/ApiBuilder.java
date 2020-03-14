package api.shmehdi.shialyricsapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

class ApiBuilder {

    private final static String BASE_URL = "http://alzulfiquar.com/";
    private final static String LYRICS_API = "lyrics/apiv1_2.php";

    static Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient getClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return okHttpClient.build();
    }

    interface ApiService {

        @GET(LYRICS_API)
        Call<JsonArray> getArtist(@Query("q") String query, @Query("type") String type, @Query("format") String format);

        @GET(LYRICS_API)
        Call<JsonArray> getYears(@Query("q") String query, @Query("type") String type, @Query("format") String format, @Query("id") String id);

        @GET(LYRICS_API)
        Call<JsonArray> getTitles(@Query("q") String query, @Query("type") String type, @Query("format") String format, @Query("id") String id, @Query("year") String year);

        @GET(LYRICS_API)
        Call<JsonObject> getLyrics(@Query("q") String query, @Query("id") String id);

        @GET(LYRICS_API)
        Call<String> getSearchCount(@Query("q") String query, @Query("terms") String terms);

        @GET(LYRICS_API)
        Call<JsonArray> getSearch(@Query("q") String query, @Query("format") String format, @Query("terms") String terms);
    }
}
