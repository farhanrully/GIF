package com.example.gif.model.explore;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class ExploreResponse {

	@SerializedName("locale")
	private String locale;

	@SerializedName("tags")
	private ArrayList<ExploreItem> tags;

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setTags(ArrayList<ExploreItem> tags){
		this.tags = tags;
	}

	public ArrayList<ExploreItem> getTags(){
		return tags;
	}
}