package com.narne.tracker.domain;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Pet {
	
    @Id
    private ObjectId _id;
    private String name;
    private String species;
    private String birthday;
    private String imageUrl;

    
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 public ObjectId getId() {
	        return _id;
	    }

	    public void setId(ObjectId id) {
	        this._id = id;
	    }
}
