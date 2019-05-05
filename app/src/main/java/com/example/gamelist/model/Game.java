package com.example.gamelist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("rating")
    @Expose
    private int rating;

    @SerializedName("cover")
    @Expose
    private int cover;

    /*@SerializedName("involved_companies")
    @Expose
    private List<Integer> companies = new ArrayList<Integer>();*/

    @SerializedName("summary")
    @Expose
    private String summary;

    @SerializedName("url")
    @Expose
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /*public List<Integer> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Integer> companies) {
        this.companies = companies;
    }*/
}
