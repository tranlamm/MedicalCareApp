package model;

public class Account {
	private String taiKhoan;
	private String matKhau;
	
	public Account(String taiKhoan, String matKhau) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	
	public Account() {
	}
	
	public String getTaiKhoan() {
		return taiKhoan;
	}
	
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	public String getMatKhau() {
		return matKhau;
	}
	
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
}
