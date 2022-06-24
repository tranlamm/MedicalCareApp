package model.core;

public class HistoryMedical {
	
	public String dateOfInjection; // ngày chích
	public String typeOfVaccine; // loại
	public String IDVaccine; // số lô "int"
	public String interaction; // phản ứng
	public String idKid;
	
	public String getDateOfInjection() {
		return dateOfInjection;
	}
	public void setDateOfInjection(String dateOfInjection) {
		this.dateOfInjection = dateOfInjection;
	}
	public String getTypeOfVaccine() {
		return typeOfVaccine;
	}
	public void setTypeOfVaccine(String typeOfVaccine) {
		this.typeOfVaccine = typeOfVaccine;
	}
	public String getInteraction() {
		return interaction;
	}
	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}
	public String getIDVaccine() {
		return IDVaccine;
	}
	public void setIDVaccine(String iDVaccine) {
		IDVaccine = iDVaccine;
	}
	public String getIdKid() {
		return idKid;
	}
	public void setIdKid(String idKid) {
		this.idKid = idKid;
	}
	public HistoryMedical(String dateOfInjection, String typeOfVaccine, String iDVaccine, String interaction,
			String idKid) {
		this.dateOfInjection = dateOfInjection;
		this.typeOfVaccine = typeOfVaccine;
		IDVaccine = iDVaccine;
		this.interaction = interaction;
		this.idKid = idKid;
	}
}
