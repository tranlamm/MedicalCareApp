package model.core;

import java.util.Date;

public class HistoryMedical {
	
	public Date dateOfInjection; // ngày chích
	public String typeOfVaccine; // loại
	public int IDVaccine; // số lô "int"
	public String address; // địa điểm
	public String interaction; // phản ứng
	public String imageHist; // ảnh
	public Date nextAppointment; // hẹn lần tiếp
	
	
	public Date getDateOfInjection() {
		return dateOfInjection;
	}
	public void setDateOfInjection(Date dateOfInjection) {
		this.dateOfInjection = dateOfInjection;
	}
	public String getTypeOfVaccine() {
		return typeOfVaccine;
	}
	public void setTypeOfVaccine(String typeOfVaccine) {
		this.typeOfVaccine = typeOfVaccine;
	}
	public int getIDVaccine() {
		return IDVaccine;
	}
	public void setIDVaccine(int iDVaccine) {
		IDVaccine = iDVaccine;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInteraction() {
		return interaction;
	}
	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}
	public String getImageHist() {
		return imageHist;
	}
	public void setImageHist(String imageHist) {
		this.imageHist = imageHist;
	}
	public Date getNextAppointment() {
		return nextAppointment;
	}
	public void setNextAppointment(Date nextAppointment) {
		this.nextAppointment = nextAppointment;
	}
	public HistoryMedical( Date dateOfInjection, String typeOfVaccine, int iDVaccine, String address,
			String interaction, String imageHist, Date nextAppointment) {
		this.dateOfInjection = dateOfInjection;
		this.typeOfVaccine = typeOfVaccine;
		IDVaccine = iDVaccine;
		this.address = address;
		this.interaction = interaction;
		this.imageHist = imageHist;
		this.nextAppointment = nextAppointment;
	}
	@Override
	public String toString() {
		return "HistoryMedical [dateOfInjection=" + dateOfInjection + ", typeOfVaccine=" + typeOfVaccine
				+ ", IDVaccine=" + IDVaccine + ", address=" + address + ", interaction=" + interaction + ", imageHist="
				+ imageHist + ", nextAppointment=" + nextAppointment + "]";
	}
	
	
}
