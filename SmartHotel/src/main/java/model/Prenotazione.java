package model;

import java.util.Date;

public class Prenotazione {

	private int idPrenotazione;
	private Date dataPrenotazione;
	private Date checkIn;
	private Date checkOut;
	private String camera;
	private String intestatario;
	private int numOspiti;
	private double prezzo;
	
	public Prenotazione() {
		
	}
	
	public Prenotazione(int idPrenotazione, Date dataPrenotazione, Date checkIn, Date checkOut, String camera,
			String intestatario, int numOspiti) {
		super();
		this.idPrenotazione = idPrenotazione;
		this.dataPrenotazione = dataPrenotazione;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.camera = camera;
		this.intestatario = intestatario;
		this.numOspiti = numOspiti;
		
	}

	@Override
	public String toString() {
		return "Prenotazione [idPrenotazione=" + idPrenotazione + ", dataPrenotazione=" + dataPrenotazione + ", checkIn=" + checkIn + ", checkOut=" 
				+ checkOut + ", camera=" + camera + ", intestatario=" + intestatario + ", numOspiti=" + numOspiti + "]";
	}

	public int getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	/*
	 * public void setCameraId(String idCamera) { this.camera.setIdCamera(idCamera);
	 * }
	 */
	public String getIntestatario() {
		return intestatario;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	public int getNumOspiti() {
		return numOspiti;
	}
	public void setNumOspiti(int numOspiti) {
		this.numOspiti = numOspiti;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
}
