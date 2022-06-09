package model.core;

import java.util.ArrayList;
import java.util.Objects;

public class  Person {
	protected String ID; 
	protected String lastName; 
	protected String firstName;
	protected String dateOfBirth;
	protected String address;
	protected String phoneNum;
	protected String email;
	protected ArrayList<WeightHeight> wH;
	
	
	public ArrayList<WeightHeight> getwH() {
		return wH;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person(String iD, String firstName, String lastName, String dateOfBirth, String address, String email, String phoneNum,
			ArrayList<WeightHeight> wH) {
		ID = iD;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.email = email;
		this.phoneNum = phoneNum;
		this.wH = wH;
	}
	
	public Person() {
		this.ID = null;
		this.lastName = null;
		this.firstName = null;
		this.dateOfBirth = null;
		this.address = null;
		this.email = null;
		this.phoneNum = null;
		this.wH = null;
	}
	
	public Person(String ID) {
		this.ID = ID;
		this.lastName = null;
		this.firstName = null;
		this.dateOfBirth = null;
		this.address = null;
		this.email = null;
		this.phoneNum = null;
		this.wH = null;
	}
	
	public Person(String iD, String firstName, String lastName, String dateOfBirth, String address, String email, String phoneNum) {
		this.ID = iD;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.email = email;
		this.phoneNum = phoneNum;
		this.wH = null;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(ID, other.ID);
	}
	
}
