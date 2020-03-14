package api.shmehdi.shialyricsapi.annotation;

import androidx.annotation.StringDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static api.shmehdi.shialyricsapi.annotation.ApiQuery.LIST;
import static api.shmehdi.shialyricsapi.annotation.ApiQuery.LYRICS;
import static api.shmehdi.shialyricsapi.annotation.ApiQuery.NAUHAKHAN;
import static api.shmehdi.shialyricsapi.annotation.ApiQuery.SEARCH;
import static api.shmehdi.shialyricsapi.annotation.ApiQuery.SEARCH_COUNT;
import static api.shmehdi.shialyricsapi.annotation.ApiQuery.YEAR;


@StringDef({NAUHAKHAN, YEAR, LIST, LYRICS, SEARCH_COUNT, SEARCH})
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface ApiQuery {
    String NAUHAKHAN = "nauhakhwan"; //ARTIST
    String YEAR = "year";
    String LIST = "list";
    String LYRICS = "lyric";
    String SEARCH_COUNT = "searchcount";
    String SEARCH = "search";

}





