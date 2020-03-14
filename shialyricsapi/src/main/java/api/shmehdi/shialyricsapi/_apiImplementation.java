package api.shmehdi.shialyricsapi;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import api.shmehdi.shialyricsapi.models.Artist;
import api.shmehdi.shialyricsapi.models.Lyrics;
import api.shmehdi.shialyricsapi.models.SearchResult;
import api.shmehdi.shialyricsapi.models.Title;
import api.shmehdi.shialyricsapi.models.Year;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class _apiImplementation {

    private static final String TAG = "_apiImplementation";

    static void _artist(final LyricsApi lyricsApi, final LyricsApi.ApiResponse<List<Artist>> apiResponse) {
        lyricsApi.builder.loader.onLoading(true);
        lyricsApi.apiService.getArtist(lyricsApi.builder.query, lyricsApi.builder.type, lyricsApi.builder.format).enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(@NonNull Call<JsonArray> call, @NonNull Response<JsonArray> response) {
                lyricsApi.builder.loader.onLoading(false);
                if (handleResponse(response, lyricsApi)) {
                    ArrayList<Artist> artists = new Gson().fromJson(response.body(), new TypeToken<ArrayList<Artist>>() {
                    }.getType());
                    apiResponse.onResponse(artists);
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonArray> call, @NonNull Throwable t) {
                handleError(t, -1, lyricsApi);
            }
        });
    }

    static void _years(final LyricsApi lyrcisApi, @NonNull final LyricsApi.ApiResponse<List<Year>> apiResponse) {
        lyrcisApi.builder.loader.onLoading(true);
        lyrcisApi.apiService.getYears(lyrcisApi.builder.query,
                lyrcisApi.builder.type
                , lyrcisApi.builder.format,
                lyrcisApi.builder.id)
                .enqueue(new Callback<JsonArray>() {
                    @Override
                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        lyrcisApi.builder.loader.onLoading(false);
                        if (handleResponse(response, lyrcisApi)) {
                            ArrayList<Year> years = new Gson().fromJson(response.body(), new TypeToken<ArrayList<Year>>() {
                            }.getType());
                            apiResponse.onResponse(years);
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonArray> call, Throwable t) {
                        handleError(t, -1, lyrcisApi);
                    }
                });

    }

    static void _titles(final LyricsApi lyricsApi, @NonNull final LyricsApi.ApiResponse<List<Title>> apiResponse) {
        lyricsApi.builder.loader.onLoading(true);
        lyricsApi.apiService.getTitles(lyricsApi.builder.query,lyricsApi.builder.type,lyricsApi.builder.format, lyricsApi.builder.id,lyricsApi.builder.year)
                .enqueue(new Callback<JsonArray>() {
                    @Override
                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        lyricsApi.builder.loader.onLoading(false);
                        if(handleResponse(response,lyricsApi)) {
                            ArrayList<Title> titles = new Gson().fromJson(response.body(), new TypeToken<ArrayList<Title>>() {
                            }.getType());
                            apiResponse.onResponse(titles);
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonArray> call, Throwable t) {
                        handleError(t,-1,lyricsApi);
                    }
                });
    }

    static void _lyrics(final LyricsApi lyricsApi, @NonNull final LyricsApi.ApiResponse<Lyrics> apiResponse) {
        lyricsApi.builder.loader.onLoading(true);
        lyricsApi.apiService.getLyrics(lyricsApi.builder.query,lyricsApi.builder.id)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        lyricsApi.builder.loader.onLoading(false);
                        if(handleResponse(response,lyricsApi)) {
                            Lyrics lyrics = new Gson().fromJson(response.body(), Lyrics.class);
                            apiResponse.onResponse(lyrics);
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        handleError(t,-1,lyricsApi);
                    }
                });
    }

    static void _count(final LyricsApi lyricsApi, @NonNull final LyricsApi.ApiResponse<String> apiResponse, String query) {
        lyricsApi.builder.loader.onLoading(true);
        lyricsApi.apiService.getSearchCount(lyricsApi.builder.query,query)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        lyricsApi.builder.loader.onLoading(false);
                        if(handleResponse(response,lyricsApi)) {
                            apiResponse.onResponse(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        handleError(t,-1,lyricsApi);
                    }
                });
    }

    static void _search(final LyricsApi lyricsApi, @NonNull final LyricsApi.ApiResponse<List<SearchResult>> apiResponse, String query) {
        lyricsApi.builder.loader.onLoading(true);
        lyricsApi.apiService.getSearch(lyricsApi.builder.query,lyricsApi.builder.format,query)
                .enqueue(new Callback<JsonArray>() {
                    @Override
                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        lyricsApi.builder.loader.onLoading(true);
                        if(handleResponse(response,lyricsApi)) {
                            ArrayList<SearchResult> searchResults = new Gson().fromJson(response.body(), new TypeToken<ArrayList<SearchResult>>() {
                            }.getType());
                            apiResponse.onResponse(searchResults);
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonArray> call, Throwable t) {
                        handleError(t,-1,lyricsApi);
                    }
                });
    }

    private static void handleError(Object o, int errorCode, LyricsApi shiaLyricsApi) {
        String error = "Something Went Wrong";

        if (o instanceof Throwable) {
            Throwable t = (Throwable) o;
            error = t.getLocalizedMessage() != null && !t.getLocalizedMessage().isEmpty() ? t.getLocalizedMessage() : "Something went wrong";

        } else if (o instanceof String) {
            error = (String) o;
        } else if (o instanceof Response) {
            Response response = (Response) o;
            try {
                assert response.errorBody() != null;
                error = response.errorBody().string() + " status code: " + response.code();
            } catch (Exception e) {
                e.printStackTrace();
                error = "Error " + e.getMessage() + " status code: " + response.code();
            }
        }

        if (BuildConfig.DEBUG) Log.e(TAG, "handleError: " + error);
        if (shiaLyricsApi.loader != null) {
            shiaLyricsApi.loader.onLoading(false);
        }
        if (shiaLyricsApi.errorListener != null) {
            shiaLyricsApi.errorListener.onError(error, errorCode);
        }
    }

    private static boolean handleResponse(Response response, LyricsApi lyricsApi) {
        boolean b = true;
        if (response.isSuccessful() && response.body() != null) {
            if (lyricsApi.builder.rawResponse != null)
                lyricsApi.builder.rawResponse.onResponse(response.body());

        } else {
            handleError(response, response.code(), lyricsApi);
            b = false;
        }
        return b;
    }
}
