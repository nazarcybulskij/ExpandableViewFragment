package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nazar on 10.06.15.
 */
public class Competision_to_do {
    @SerializedName("vik1")
    List<Integer> vik1;
    @SerializedName("vik2")
    List<Integer> vik2;

    public List<Integer> getVik1() {
        return vik1;
    }

    public void setVik1(List<Integer> vik1) {
        this.vik1 = vik1;
    }

    public List<Integer> getVik2() {
        return vik2;
    }

    public void setVik2(List<Integer> vik2) {
        this.vik2 = vik2;
    }
}
