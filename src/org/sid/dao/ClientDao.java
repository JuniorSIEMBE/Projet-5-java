package org.sid.dao;

import java.util.List;

import org.sid.entities.Client;

public interface ClientDao {
	
	public void Ajouter(Client c);
	public void supprimer(int code);
	public void modifier(int code, Client c);
	public List<Client> lister();
	public Client chercher(int code);
	public List<Client> chercher(String name);
	
}
