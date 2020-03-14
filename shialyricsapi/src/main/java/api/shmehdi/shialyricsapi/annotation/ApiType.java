package api.shmehdi.shialyricsapi.annotation;

import androidx.annotation.StringDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static api.shmehdi.shialyricsapi.annotation.ApiType.MANQABAT;
import static api.shmehdi.shialyricsapi.annotation.ApiType.MARSIYA;
import static api.shmehdi.shialyricsapi.annotation.ApiType.NAUHA;

@StringDef({NAUHA,MANQABAT,MARSIYA})
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface ApiType {
    String NAUHA = "Nauha";
    String MANQABAT = "Manqabat";
    String MARSIYA = "Marsiya";
}
