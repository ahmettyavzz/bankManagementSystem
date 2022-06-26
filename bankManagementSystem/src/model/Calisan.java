package model;

import helper.DBHelper;

//import java.sql.Connection;



public class Calisan {
	

	private int id;
	private String adSoyad;
	private String tcNo;
	private String eMail;
	private String telefon;
	private String adres;
	private String sifre;
	private String temsilciNo;
	
	DBHelper dbHelper=new DBHelper();
	
	
//	public Calisan(int id, String adSoyad, String tcNo, String eMail, String telefon, String adres, String sifre) {
//		super();
//		this.id = id;
//		this.adSoyad = adSoyad;
//		this.tcNo = tcNo;
//		this.eMail = eMail;
//		this.telefon = telefon;
//		this.adres = adres;
//		this.sifre = sifre;
//	}
//	
	
	public Calisan(int id, String adSoyad, String tcNo, String eMail, String telefon, String adres, String temsilciNo) {
		super();
		this.id = id;
		this.adSoyad = adSoyad;
		this.tcNo = tcNo;
		this.eMail = eMail;
		this.telefon = telefon;
		this.adres = adres;
		this.temsilciNo = temsilciNo;
	}


	public String getTemsilciNo() {
		return temsilciNo;
	}


	public void setTemsilciNo(String temsilciNo) {
		this.temsilciNo = temsilciNo;
	}


	public Calisan() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	
	
	
	
	
}
