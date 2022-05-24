package model;

public class Camera {

	private String idCamera;
	private String tipo;
	private int numPosti;
	private int dimensione;
	private double prezzo;
	private int numCamera;
	private boolean prenotabile;
	private String descrizione;


	public Camera() {
		
	}
	
	public Camera(String idCamera, String tipo, int numPosti, int dimensione, double prezzo, int numCamera, String descrizione) {
		super();
		this.idCamera = idCamera;
		this.tipo = tipo;
		this.numPosti = numPosti;
		this.dimensione = dimensione;
		this.prezzo = prezzo;
		this.numCamera = numCamera;
		this.descrizione = descrizione;
		this.prenotabile = true;
	}

	
	@Override
	public String toString() {
		return "Camera [idCamera=" + idCamera + ", tipo=" + tipo + ", numPosti=" + numPosti + ", dimensione="
				+ dimensione + ", prezzo=" + prezzo + ", numCamera=" + numCamera+ ", descrizione=" + descrizione + "]";
	}

	public String getIdCamera() {
		return idCamera;
	}
	public void setIdCamera(String idCamera) {
		this.idCamera = idCamera;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumPosti() {
		return numPosti;
	}
	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
	public int getDimensione() {
		return dimensione;
	}
	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getNumCamera() {
		return numCamera;
	}
	public void setNumCamera(int numCamera) {
		this.numCamera = numCamera;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public boolean isPrenotabile() {
		return prenotabile;
	}
	public void setPrenotabile(boolean prenotabile) {
		this.prenotabile = prenotabile;
	}
	
}
