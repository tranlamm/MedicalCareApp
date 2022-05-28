package model;

import java.util.Arrays;
import java.util.Objects;

public class Mom extends Person{
	private float weight;
	private String appointment;
	private String healthStatus;
	private String EDD;
	
	public Mom() {
		super();
	}
	
	public Mom(String ID) {
		super(ID);
	}

	public Mom(String iD, String lastName, String firstName, String dateOfBirth, String address, String email, String phoneNum,
			WeightHeight[] fetalWH ) {
		super(iD, lastName, firstName, dateOfBirth, address, email, phoneNum, fetalWH);

	}

	public Mom(String id, String lastName, String firstName, String dateOfBirth, String address, String email, String phoneNum) {
		super(id, lastName, firstName, dateOfBirth, address, email, phoneNum);
	}
	
	public Mom(String id, String lastName, String firstName, String dateOfBirth, 
			String address, String email, String phoneNum, float weight, String appointment,
			String healthStatus, String EDD) {
		super(id, lastName, firstName, dateOfBirth, address, email, phoneNum);
		this.weight = weight;
		this.appointment = appointment;
		this.healthStatus = healthStatus;
		this.EDD = EDD;
	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getEDD() {
		return EDD;
	}

	public void setEDD(String eDD) {
		EDD = eDD;
	}
	
	@Override
	public String toString() {
		return "Mom [weight=" + weight + ", appointment=" + appointment + ", healthStatus=" + healthStatus + ", EDD="
				+ EDD + ", ID=" + ID + ", lastName=" + lastName + ", firstName=" + firstName + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", phoneNum=" + phoneNum + ", email=" + email + 
				", wH=" + Arrays.toString(wH) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(EDD, appointment, healthStatus, weight);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mom other = (Mom) obj;
		return Objects.equals(this.ID, other.ID);
	}	
	
}
