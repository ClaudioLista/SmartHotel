package model;

import java.sql.Date;

public class Comanda {

	private int idOrdine;
	private int idPrenotazione;
	private String dataOrdine;
	private String intestararioOrdine;
	private String numCamera;
	private String dipendenteBar;
	private boolean servito;
	private String ordine;
	private double totale;
	
	public String getDataOrdine() {
		return dataOrdine;
	}
	public void setDataOrdine(String string) {
		this.dataOrdine = string;
	}
	public String getIntestararioOrdine() {
		return intestararioOrdine;
	}
	public void setIntestararioOrdine(String intestararioOrdine) {
		this.intestararioOrdine = intestararioOrdine;
	}
	public String getDipendenteBar() {
		return dipendenteBar;
	}
	public void setDipendenteBar(String dipendenteBar) {
		this.dipendenteBar = dipendenteBar;
	}
	public boolean isServito() {
		return servito;
	}
	public void setServito(boolean servito) {
		this.servito = servito;
	}
	public String getOrdine() {
		return ordine;
	}
	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public int getIdOrdine() {
		return idOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public Comanda() {
		// TODO Auto-generated constructor stub
	}
	public String getNumCamera() {
		return numCamera;
	}
	public void setNumCamera(String string) {
		this.numCamera = string;
	}
	public Comanda(int idOrdine, int idPrenotazione, String dataOrdine, String intestararioOrdine, String numCamera,
			String dipendenteBar, boolean servito, String ordine, double totale) {
		super();
		this.idOrdine = idOrdine;
		this.idPrenotazione = idPrenotazione;
		this.dataOrdine = dataOrdine;
		this.intestararioOrdine = intestararioOrdine;
		this.numCamera = numCamera;
		this.dipendenteBar = dipendenteBar;
		this.servito = servito;
		this.ordine = ordine;
		this.totale = totale;
	}
	public int getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	
}
