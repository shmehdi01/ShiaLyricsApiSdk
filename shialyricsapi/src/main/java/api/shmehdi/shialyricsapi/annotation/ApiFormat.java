package api.shmehdi.shialyricsapi.annotation;

import androidx.annotation.StringDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static api.shmehdi.shialyricsapi.annotation.ApiFormat.JSON;

@StringDef({JSON})
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface ApiFormat {
    String JSON = "json";
}
