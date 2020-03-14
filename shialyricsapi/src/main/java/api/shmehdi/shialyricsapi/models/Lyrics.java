
package api.shmehdi.shialyricsapi.models;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Lyrics extends ApiModel {

    @SerializedName("audio")
    private String mAudio;
    @SerializedName("lyrics")
    private String mLyrics;
    @SerializedName("reciter")
    private String mReciter;
    @SerializedName("type")
    private String mType;
    @SerializedName("video")
    private String mVideo;
    @SerializedName("year")
    private String mYear;

    public String getAudio() {
        return mAudio;
    }

    public void setAudio(String audio) {
        mAudio = audio;
    }

    public String getLyrics() {
        return mLyrics;
    }

    public void setLyrics(String lyrics) {
        mLyrics = lyrics;
    }

    public String getReciter() {
        return mReciter;
    }

    public void setReciter(String reciter) {
        mReciter = reciter;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getVideo() {
        return mVideo;
    }

    public void setVideo(String video) {
        mVideo = video;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

}
