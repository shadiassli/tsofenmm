package Models;

import java.sql.Date;

public class Mentee {
	int UserId;
	int MentorId;
	Date RegistrationDate;
	String Gender;
	String Address;
	String EducationStatus;
	String Acadimicinstitution;
	int SemesretLeft;
	int TsofenCurse;
	String Notes;
	
	
	
	
	public Mentee(int userId, int mentorId, Date registrationDate, String gender, String address,
			String educationStatus, String acadimicinstitution, int semesretLeft, int tsofenCurse, String notes) {
		super();
		UserId = userId;
		MentorId = mentorId;
		RegistrationDate = registrationDate;
		Gender = gender;
		Address = address;
		EducationStatus = educationStatus;
		Acadimicinstitution = acadimicinstitution;
		SemesretLeft = semesretLeft;
		TsofenCurse = tsofenCurse;
		Notes = notes;
	}
	
	public Mentee(){
		
	}
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getMentorId() {
		return MentorId;
	}
	public void setMentorId(int mentorId) {
		MentorId = mentorId;
	}
	public Date getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		RegistrationDate = registrationDate;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEducationStatus() {
		return EducationStatus;
	}
	public void setEducationStatus(String educationStatus) {
		EducationStatus = educationStatus;
	}
	public String getAcadimicinstitution() {
		return Acadimicinstitution;
	}
	public void setACADIMICINSTITUTION(String acadimicinstitution) {
		Acadimicinstitution = acadimicinstitution;
	}
	public int getSemesretLeft() {
		return SemesretLeft;
	}
	public void setSemesretLeft(int semesretLeft) {
		SemesretLeft = semesretLeft;
	}
	public int getTsofenCurse() {
		return TsofenCurse;
	}
	public void setTsofenCurse(int tsofenCurse) {
		TsofenCurse = tsofenCurse;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	
	
}
