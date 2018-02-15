package com.narne.tracker.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class DoctorVisit {

    @Id
    private ObjectId _id;
	private String petId;	
	private String doctorName;	
	private String visitDate;	
	private String visitReason;

	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}
	
	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}
	
	
}
