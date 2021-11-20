package org.sid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory{
	
	private String url;
	private String userName;
	private String password;

	DaoFactory(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public static DaoFactory getInstance(){
	try{
		//Chargement du pilote
		Class.forName("com.mysql.jdbc.Driver");
	}catch (ClassNotFoundException e){
		e.printStackTrace();
	}
	//Etablissement de la connexion
		String url = "jdbc:mysql://localhost:3306/banque";
		String userName = "root";
		String password = "";
		DaoFactory instance = new DaoFactory(url,userName,password);
		return instance;
	}

	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, userName, password);
	}

	public ClientDao getUtilisateurDao(){
		return new ClientDaoImpl(this);
	}
	
}
	
