package model;

import helper.DBHelper;

public class Musteri extends Calisan{
	
	private int bakiye;
	private String iban;
	
	
	DBHelper dbHelper=new DBHelper();



	

	public Musteri(int id, String adSoyad, String tcNo, String eMail, String telefon, String adres, String temsilciNo,
			int bakiye, String iban) {
		super(id, adSoyad, tcNo, eMail, telefon, adres, temsilciNo);
		this.bakiye = bakiye;
		this.iban = iban;
	}



	public Musteri() {
	
	}



	public Musteri(int id, String adSoyad, String tcNo, String eMail, String telefon, String adres, String temsilciNo) {
		super(id, adSoyad, tcNo, eMail, telefon, adres, temsilciNo);
	}



	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public int getBakiye() {
		return bakiye;
	}

	public void setBakiye(int bakiye) {
		this.bakiye = bakiye;
	}
	
}
