package org.sid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sid.entities.Client;

public class ClientDaoImpl implements ClientDao{
	
	private DaoFactory factory;

	ClientDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void Ajouter(Client c) {
		Connection con= null;
		PreparedStatement statement = null;
		
		try {
			con = factory.getConnection();
			statement = con.prepareStatement("INSERT INTO client(names, address, phone, compte_id) "
					+ "VALUES (?,?,?,?)");
			statement.setString(1, c.getNames());
			statement.setString(2, c.getAddress());
			statement.setString(3, c.getPhone());
			statement.setInt(4, c.getCompte().getCode());
			
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer(int code) {
		Connection con= null;
		PreparedStatement statement = null;
		
		try {
			con = factory.getConnection();
			statement = con.prepareStatement("DELETE FROM client WHERE code=?");
			statement.setInt(1, code);
			
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(int code, Client c) {
		Connection con= null;
		PreparedStatement statement = null;
		
		try {
			con = factory.getConnection();
			statement = con.prepareStatement("UPDATE client SET names=? AND address=? AND phone=? WHERE compte_id=?");
			statement.setString(1, c.getNames());
			statement.setString(2, c.getAddress());
			statement.setString(3, c.getPhone());
			statement.setInt(4, c.getCompte().getCode());
			
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Client> lister() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result;
		List<Client> lists = new ArrayList<Client>();
		
		try {
			con = factory.getConnection();
			stmt = con.prepareStatement("SELECT names,address,phone,compte_id FROM client");
			result = stmt.executeQuery();
			while(result.next()) {
				String names = result.getString("names");
				String address = result.getString("address");
				String phone = result.getString("phone");
				Client c = new Client(names, address, phone);
				lists.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lists;
	}

	@Override
	public Client chercher(int code) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result;
		Client c = null;
		
		try {
			con = factory.getConnection();
			stmt = con.prepareStatement("SELECT names,address,phone,compte_id FROM client WHERE compte_id=?");
			stmt.setInt(1, code);
			result = stmt.executeQuery();
			while(result.next()) {
				String names = result.getString("names");
				String address = result.getString("address");
				String phone = result.getString("phone");
				c = new Client(names, address, phone);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public List<Client> chercher(String name) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result;
		List<Client> lists = new ArrayList<Client>();
		
		try {
			con = factory.getConnection();
			stmt = con.prepareStatement("SELECT names,address,phone,compte_id FROM client WHERE names like ?%");
			result = stmt.executeQuery();
			while(result.next()) {
				String names = result.getString("names");
				String address = result.getString("address");
				String phone = result.getString("phone");
				Client c = new Client(names, address, phone);
				lists.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lists;
	}

}
