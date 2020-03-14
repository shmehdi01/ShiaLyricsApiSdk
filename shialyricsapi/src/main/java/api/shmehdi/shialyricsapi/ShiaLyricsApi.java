package api.shmehdi.shialyricsapi;

import androidx.annotation.NonNull;

import java.util.List;

import api.shmehdi.shialyricsapi.models.Artist;
import api.shmehdi.shialyricsapi.models.Lyrics;
import api.shmehdi.shialyricsapi.models.SearchResult;
import api.shmehdi.shialyricsapi.models.Title;
import api.shmehdi.shialyricsapi.models.Year;

public interface ShiaLyricsApi {

    void getArtist(@NonNull LyricsApi.ApiResponse<List<Artist>> response);

    void getYears(@NonNull LyricsApi.ApiResponse<List<Year>> response);

    void getTitles(@NonNull LyricsApi.ApiResponse<List<Title>> response);

    void getLyrics(@NonNull LyricsApi.ApiResponse<Lyrics> response);

    void getSearchCount(String query, LyricsApi.ApiResponse<String > response);

    void getSearch(String query, @NonNull LyricsApi.ApiResponse<List<SearchResult>> response);
}
