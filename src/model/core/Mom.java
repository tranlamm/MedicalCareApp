package model.core;

import java.util.ArrayList;
import java.util.Objects;

public class Mom extends Person{
	private String appointment;
	private String healthStatus;
	private String EDD;
	
	public Mom() {
		super();
	}
	
	public Mom(String ID) {
		super(ID);
	}

	public Mom(String iD, String firstName, String lastName, String dateOfBirth, String address, String email, String phoneNum,
			String fetalWH, String appointment, String status, String edd) {
		super(iD, firstName, lastName, dateOfBirth, address, email, phoneNum);
		this.appointment = appointment;
		this.healthStatus = status;
		this.EDD = edd;
		this.wH = new ArrayList<WeightHeight>();
		
		if (fetalWH == null || fetalWH.trim().equals("")) return;
		String x = fetalWH.trim();
		String tmp[] = x.split(" ");
		for (int i = 0; i < tmp.length; ++i)
		{
			try {
				float w = Float.parseFloat(tmp[i]);
				this.wH.add(new WeightHeight(w));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Mom(String id, String firstName, String lastName, String dateOfBirth, String address, String email, String phoneNum) {
		super(id, firstName, lastName, dateOfBirth, address, email, phoneNum);
	}
	
	public ArrayList<WeightHeight> getWeight()
	{
		return wH;
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

	public void setEDD(String EDD) {
		this.EDD = EDD;
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
