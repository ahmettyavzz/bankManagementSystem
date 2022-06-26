package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

//import helper.DBHelper;


public class MusteriMT extends Calisan{
	
	Statement statement=null;
	ResultSet resultSet=null;
	PreparedStatement preparedStatement=null;
	Connection connection;
	
	public MusteriMT(int id, String adSoyad, String tcNo, String eMail, String telefon, String adres,
			String temsilciNo) {
		super(id, adSoyad, tcNo, eMail, telefon, adres, temsilciNo);
	}
	
	public MusteriMT() {
		
	}



	public ArrayList<Calisan> getMusteriList() throws SQLException{
		ArrayList<Calisan> list =new ArrayList<>();
		connection=dbHelper.getConnection();
		
		Calisan objMusteri;
		
	try {
		
		statement=connection.createStatement();
		resultSet=statement.executeQuery("SELECT * FROM bilgiler");
		while (resultSet.next()) {
			objMusteri=new Calisan(resultSet.getInt("idbilgiler"),resultSet.getString("Ad_Soyad")
					,resultSet.getString("E_Mail"),resultSet.getString("Telefon")
					,resultSet.getString("Tc_No")
					,resultSet.getString("Adres")
					,resultSet.getString("TemsilciNo"));
			
			list.add(objMusteri);
		}
		
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	//finally{
//		
//		connection.close();
//	}
	
	return list;	
	}
	
	public boolean addMusteri(String adSoyad,String eMail, String Telefon,String TcNo,String sifre,String Adres,String bakiye,String temsilciNo,String iban) throws SQLException
	{
		String query= "INSERT INTO bilgiler "+"(Ad_Soyad,E_Mail,Telefon,Tc_No,Sifre,Adres,Bakiye,TemsilciNo,IBAN)" + " VALUES (?,?,?,?,?,?,?,?,?)";
		boolean key=false;
		int geciciBakiye=Integer.parseInt(bakiye);
		try {
			statement=connection.createStatement();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, adSoyad);
			preparedStatement.setString(2, eMail);
			preparedStatement.setString(3, Telefon);
			preparedStatement.setString(4, TcNo);
			preparedStatement.setString(5, sifre);
			preparedStatement.setString(6, Adres);
			preparedStatement.setInt(7, geciciBakiye);
			preparedStatement.setString(8, temsilciNo);
			preparedStatement.setString(9, iban);
			preparedStatement.executeUpdate();
			key=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if (key==true) 
			return true;
		else 
			return false;
		
		
	}

	
}
