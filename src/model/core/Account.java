package model.core;

public class Account {
	private String taiKhoan;
	private String matKhau;
	private String type;
	private String id;
	
	public Account(String taiKhoan, String matKhau, String type, String id) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.type = type;
		this.id = id;
	}

	public Account(String taiKhoan, String matKhau, String type) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.type = type;
	}
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
