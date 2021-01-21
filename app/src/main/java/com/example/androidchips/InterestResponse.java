package com.example.androidchips;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class InterestResponse{

	@SerializedName("interests")
	private List<InterestsItem> interests;

	@SerializedName("status")
	private boolean status;

	public void setInterests(List<InterestsItem> interests){
		this.interests = interests;
	}

	public List<InterestsItem> getInterests(){
		return interests;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"InterestResponse{" + 
			"interests = '" + interests + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}