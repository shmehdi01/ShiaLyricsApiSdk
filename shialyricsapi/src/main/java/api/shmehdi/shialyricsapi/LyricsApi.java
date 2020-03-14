package api.shmehdi.shialyricsapi;

import androidx.annotation.NonNull;

import java.util.List;

import api.shmehdi.shialyricsapi.annotation.ApiFormat;
import api.shmehdi.shialyricsapi.annotation.ApiQuery;
import api.shmehdi.shialyricsapi.annotation.ApiType;
import api.shmehdi.shialyricsapi.models.Artist;
import api.shmehdi.shialyricsapi.models.Lyrics;
import api.shmehdi.shialyricsapi.models.SearchResult;
import api.shmehdi.shialyricsapi.models.Title;
import api.shmehdi.shialyricsapi.models.Year;

public class LyricsApi implements ShiaLyricsApi {

    private static final String TAG = "LyricsApi";
    Builder builder;
    ApiBuilder.ApiService apiService;
    Loader loader;
    ErrorListener errorListener;

    private LyricsApi(Builder builder) {
        this.builder = builder;
        apiService = ApiBuilder.retrofit().create(ApiBuilder.ApiService.class);
    }

    @Override
    public void getArtist(@NonNull ApiResponse<List<Artist>> response) {
        _apiImplementation._artist(this, response);
    }

    @Override
    public void getYears(@NonNull ApiResponse<List<Year>> response) {
        _apiImplementation._years(this, response);
    }

    @Override
    public void getTitles(@NonNull ApiResponse<List<Title>> response) {
        _apiImplementation._titles(this, response);
    }

    @Override
    public void getLyrics(@NonNull ApiResponse<Lyrics> response) {
        _apiImplementation._lyrics(this, response);
    }

    @Override
    public void getSearchCount(String query, ApiResponse<String> response) {
        _apiImplementation._count(this,response, query);
    }

    @Override
    public void getSearch(String query, @NonNull ApiResponse<List<SearchResult>> response) {
        _apiImplementation._search(this, response, query);
    }


    public interface Loader {
        void onLoading(boolean isLoading);
    }

    public interface ErrorListener {
        void onError(String errorMsg, int errorCode);
    }

    public interface ApiResponse<T> {
        void onResponse(T t);
    }

    public static class Builder {
        String query;
        String type;
        String format;
        String id;
        String year;
        Loader loader;
        ErrorListener errorListener;
        ApiResponse<Object> rawResponse;

        public Builder setQuery(@ApiQuery String query) {
            this.query = query;
            return this;
        }

        public Builder setType(@ApiType String type) {
            this.type = type;
            return this;
        }

        public Builder setFormat(@ApiFormat String format) {
            this.format = format;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public Builder setErrorListener(ErrorListener errorListener) {
            this.errorListener = errorListener;
            return this;
        }

        public Builder setLoader(Loader loader) {
            this.loader = loader;
            return this;
        }

        public Builder setRawResponse(ApiResponse<Object> rawResponse) {
            this.rawResponse = rawResponse;
            return this;
        }

        public ShiaLyricsApi createApi() {
            return new LyricsApi(this);
        }
    }

}
