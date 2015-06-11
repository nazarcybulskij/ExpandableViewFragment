package model;


import android.content.ClipData;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazar on 10.06.15.
 */
public class Response {
//    @SerializedName("all_competisions")
//    List<Competision> list_competisions;
//    @SerializedName("count_in_age_category")
//    AgeCategory count_in_age_category;
//    @SerializedName("count_of_competisions_to_do")
//    Competision_to_do count_of_competisions_to_do;
//
//
//    public List<Competision> getList_competisions() {
//        return list_competisions;
//    }
//
//    public void setList_competisions(List<Competision> list_competisions) {
//        this.list_competisions = list_competisions;
//    }
//
//    public Competision_to_do getCount_of_competisions_to_do() {
//        return count_of_competisions_to_do;
//    }
//
//    public void setCount_of_competisions_to_do(Competision_to_do count_of_competisions_to_do) {
//        this.count_of_competisions_to_do = count_of_competisions_to_do;
//    }
//
//    public AgeCategory getCount_in_age_category() {
//        return count_in_age_category;
//    }
//
//    public void setCount_in_age_category(AgeCategory count_in_age_category) {
//        this.count_in_age_category = count_in_age_category;
//    }


    @SerializedName("data")
    ArrayList<Item> data;

    public ArrayList<Item> getData() {
        return data;
    }

    public void setData(ArrayList<Item> data) {
        this.data = data;
    }
}
