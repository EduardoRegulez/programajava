package juego;

public class ClaseCartas {

	private int ID;
	private int numero;
	private String palo;

	public ClaseCartas(int iD, int numero, String palo) {
		ID = iD;
		this.numero = numero;
		this.palo = palo;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	public String toString() {
		return "ClaseCartas [ID=" + ID + ", numero=" + numero + ", palo=" + palo + "]";
	}

}
