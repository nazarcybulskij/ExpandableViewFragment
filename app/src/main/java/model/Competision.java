package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nazar on 10.06.15.
 */
public class Competision {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Norm> getListNorm() {
        return listNorm;
    }

    public void setListNorm(List<Norm> listNorm) {
        this.listNorm = listNorm;
    }

    @SerializedName("id")
     int id ;
    @SerializedName("competisions")
    List<Norm> listNorm;


}
