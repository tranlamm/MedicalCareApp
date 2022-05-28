package model;

public class Kid extends Person{
	private String parentName;
	private String gender;
	private HistoryMedical[] histories;

	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Kid() {
		super();
		this.gender = null;
	}
	public Kid(String id, String lastName, String firstName, String dateOfBirth, String address, String email, String phoneNum, String parentName,
			HistoryMedical[] histories, String gender, WeightHeight[] kidWH) {
		super(id, lastName, firstName, dateOfBirth, address, email, phoneNum, kidWH);
		this.gender = gender;		
		this.parentName = parentName;
		this.histories = histories;
	}
	public Kid(String id, String lastName, String firstName, String dateOfBirth, String address, String email, String phoneNum,
			String gender, String parentName) {
		super(id, lastName, firstName, dateOfBirth, address, email, phoneNum);
		this.gender = gender;
		this.parentName = parentName;
		this.histories = null;

	}
}
   
