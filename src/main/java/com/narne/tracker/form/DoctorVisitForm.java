package com.narne.tracker.form;

public class DoctorVisitForm {
	
	private String petId;	
	private String doctorName;	
	private String visitDate;	
	private String visitReason;
	
	public DoctorVisitForm(String petId) {
		this.petId = petId;
	}
	
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

	
}
