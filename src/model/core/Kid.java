package model.core;

import java.util.ArrayList;
import java.util.Objects;

public class Kid extends Person{
	private  String gender;
	private  String parentName;
	private  String appointment;
	private  String vacation;
	
	public Kid() {
		super();
	}
	
	public Kid(String ID) {
		super(ID);
	}

	public Kid(String iD, String firstName, String lastName, String dateOfBirth, String gender, String address, String email, String phoneNum, String parentName,
			String fetalWH, String appointment, String vacation) {
		super(iD, firstName, lastName, dateOfBirth, address, email, phoneNum);
		this.gender = gender;
		this.parentName = parentName;
		this.appointment = appointment;
		this.vacation = vacation;
		this.wH = new ArrayList<WeightHeight>();
		
		if (fetalWH == null) return;
		String x = fetalWH.trim();
		String tmp[] = x.split(" ");
		for (int i = 0; i < tmp.length; ++i)
		{
			String a = tmp[i].substring(0, 5);
			float b = Float.parseFloat(tmp[i].substring(6));
			this.wH.add(new WeightHeight(b, a));
		}
	}
	
	public Kid(String iD, String firstName, String lastName, String dateOfBirth, String gender, String address, String email, String phoneNum, String parentName) {
		super(iD, firstName, lastName, dateOfBirth, address, email, phoneNum);
		this.gender = gender;
		this.parentName = parentName;
	}

	public Kid(String id, String firstName, String lastName, String dateOfBirth,String address, String email, String phoneNum) {
		super(id, firstName, lastName, dateOfBirth, address, email, phoneNum);
	}


	public ArrayList<WeightHeight> getWeight()
	{
		return wH;
	}
	
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
	
	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public String getVacation() {
		return vacation;
	}

	public void setVacation(String vacation) {
		this.vacation = vacation;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kid other = (Kid) obj;
		return Objects.equals(this.ID, other.ID);
	}	
	
}
