package model.core;

import java.util.ArrayList;
import java.util.Objects;

public class Kid extends Person{
	private String gender;
	private String parentName;
	private ArrayList<HistoryMedical> historyMedicals;
	private ArrayList<WeightHeight> weight;
	private ArrayList<WeightHeight> height;
	
	public Kid() {
		super();
	}
	
	public Kid(String ID) {
		super(ID);
	}

	
	public Kid(String iD, String firstName, String lastName, String dateOfBirth, String address, String email,
			String phoneNum, String wH, String hH, String gender, String parentName,
			ArrayList<HistoryMedical> historyMedicals) {
		super(iD, firstName, lastName, dateOfBirth, address, email, phoneNum);
		this.gender = gender;
		this.parentName = parentName;
		this.historyMedicals = historyMedicals;
		this.weight = new ArrayList<WeightHeight>();
		this.height = new ArrayList<WeightHeight>();
	
		if (wH == null || wH.trim().equals("")) return;
		String x = wH.trim();
		String tmp[] = x.split(" ");
		for (int i = 0; i < tmp.length; ++i)
		{
			if(!tmp[i].equals(" "))
			{
				try {
					float w = Float.parseFloat(tmp[i].trim());
					this.weight.add(new WeightHeight(w));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if (hH == null || hH.trim().equals("")) return;
		String y = hH.trim();
		String temp[] = y.split(" ");
		for (int i = 0; i < temp.length; ++i)
		{
			if(!(temp[i].equals(" ") || temp[i].equals("")))
			{
				try {
					int h = Integer.parseInt(temp[i].trim());
					this.height.add(new WeightHeight(h));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
		return this.weight;
	}
	
	public ArrayList<WeightHeight> getHeight()
	{
		return this.height;
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

	public ArrayList<HistoryMedical> getHistoryMedicals() {
		return historyMedicals;
	}

	public void setHistoryMedicals(ArrayList<HistoryMedical> historyMedicals) {
		this.historyMedicals = historyMedicals;
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
