package org.sid.entities;

public class Client {
	
	private String names;
	
	private String address;
	
	private String phone;

	private Compte compte;

	public Client(String names, String address, String phone) {
		this.names = names;
		this.address = address;
		this.phone = phone;
		this.compte = new Compte(0);
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Client [names=" + names + ", address=" + address + ", phone=" + phone + ", compte=" + compte + "]";
	}
	
}
