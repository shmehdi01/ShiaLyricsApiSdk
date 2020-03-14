
package api.shmehdi.shialyricsapi.models;

import com.google.gson.annotations.SerializedName;

public class Title extends ApiModel {

    @SerializedName("id")
    private String mId;
    @SerializedName("title")
    private String mTitle;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
