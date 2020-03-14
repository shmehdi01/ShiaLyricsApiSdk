
package api.shmehdi.shialyricsapi.models;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Artist extends ApiModel {

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
