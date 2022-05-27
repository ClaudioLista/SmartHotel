package dao;

import java.util.ArrayList;
import java.util.Date;

import model.Prenotazione;

public interface PrenotazioneDAO {

	public int save(Prenotazione prenotazione);
	
	public int update(Prenotazione prenotazione);
	public int updateData(String idPrenotazione, Date checkIn, Date checkOut);
	public int updateIdCamera(String idNuovaCamera,String idVecchiaCamera);
	//public int updateIntestatario(String idNuovoIntestatario, String idVecchioIntestatario);
	
	public int delete (String idPrenotazione);
	public int deletebyCamera(String camera);
	
	public Prenotazione get(String idPrenotazione);
	public Prenotazione getbyCamera(String camera);
	public Prenotazione getbyIntestatario(String intestatario);
	public ArrayList<Prenotazione> getbyDate(String email, Date data);
	
	public ArrayList<Prenotazione> list();
	
}
