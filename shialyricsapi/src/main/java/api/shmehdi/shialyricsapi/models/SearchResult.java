
package api.shmehdi.shialyricsapi.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SearchResult extends ApiModel {

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("nauhakhwan_id")
    private String mNauhakhwanId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("year")
    private String mYear;

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

    public String getNauhakhwanId() {
        return mNauhakhwanId;
    }

    public void setNauhakhwanId(String nauhakhwanId) {
        mNauhakhwanId = nauhakhwanId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

}
