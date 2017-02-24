package Models;

public class Mentor {
	int UserId;
	String Gender;
	String Address;
	String Position;
	String Experience;
	String notes;
	
	
	
	public Mentor(int userId, String gender, String address, String position, String experience, String notes) {
		super();
		UserId = userId;
		Gender = gender;
		Address = address;
		Position = position;
		Experience = experience;
		this.notes = notes;
	}
	
	public Mentor(){
		
	}
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getGenser() {
		return Gender;
	}
	public void setGenser(String genser) {
		Gender = genser;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
