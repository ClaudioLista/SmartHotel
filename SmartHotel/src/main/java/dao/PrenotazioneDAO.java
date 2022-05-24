package dao;

import java.util.ArrayList;
import java.util.Date;

import model.Camera;
import model.Prenotazione;
//import model.Utente;

public interface PrenotazioneDAO {

	public int save(Prenotazione prenotazione);
	
	public int update(Prenotazione prenotazione);
	public int updateData(Date checkIn, Date checkOut);
	public int updateIdCamera(String idNuovaCamera);
	// public int updateIntestatario(Utente nuovoIntestatario);
	
	public void delete (String idPrenotazione);
	public void deletebyNumStanza(int numStanza);
	
	public Prenotazione get(String idPrenotazione);
	public ArrayList<Prenotazione> getbyNumStanza(int numStanza);
	public ArrayList<Prenotazione> getbyemailUtente(String email);
	
	public ArrayList<Prenotazione> list();
}
