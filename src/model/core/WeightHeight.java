package model.core;

public class WeightHeight {
	public int height; 
	public float weight;
	public String date;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public WeightHeight(int height, float weight, String date) {
		this.height = height;
		this.weight = weight;
		this.date = date;
	}
	
	public WeightHeight(float weight, String date) {
		this.weight = weight;
		this.date = date;
	}
	
	public WeightHeight() {
		this.height = 0;
		this.weight = 0;
		this.date = null;
	}
	@Override
	public String toString() {
		return "WeightHeight [height=" + height + ", weight=" + weight + ", date=" + date + "]";
	}
	
	
}
