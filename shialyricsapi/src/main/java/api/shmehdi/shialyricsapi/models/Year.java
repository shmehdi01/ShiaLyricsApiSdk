
package api.shmehdi.shialyricsapi.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Year extends ApiModel {

    @SerializedName("count")
    private String mCount;
    @SerializedName("name")
    private String mName;
    @SerializedName("year")
    private String mYear;

    public String getCount() {
        return mCount;
    }

    public void setCount(String count) {
        mCount = count;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

}
