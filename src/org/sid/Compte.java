package org.sid;

public class Compte {
	
	private int code;
	
	private float solde;
	
	private static int nbComptes;

	public Compte(float solde) {
		++nbComptes;
		this.code = nbComptes;
		this.solde = solde;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public static int getNbComptes() {
		return nbComptes;
	}

	public static void setNbComptes(int nbComptes) {
		Compte.nbComptes = nbComptes;
	}

	@Override
	public String toString() {
		return "Compte [code=" + code + ", solde=" + solde + "]";
	}
	
	public void verser(float mnt) {
		solde +=mnt;
	}
	
	public void retirer(float mnt) {
		
	}
}
