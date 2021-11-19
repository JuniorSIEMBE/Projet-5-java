package org.sid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agence {
	
	private String name;
	
	private List<Client> clients;
	
	public Agence(String name) {
		this.name = name;
		//Création de la liste
		clients = new ArrayList<Client>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Agence [name=" + name + ", clients=" + clients + "]";
	}
	
	public void afficherClients() {
		//Première méthode
		for(Client c: clients) {
			System.out.println(c.toString());
		}
		//deuxième méthode
		/*for(int i=0; i<clients.size();i++) {
			System.out.println(clients.get(i).toString());
		}*/
		//Troisième méthode
		/*Iterator<Client> it = clients.iterator();
		while (it.hasNext()) {
			Client c = it.next();
			System.out.println(c.toString());
		}*/
	}
}
