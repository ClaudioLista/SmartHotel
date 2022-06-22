package dao;

import java.util.ArrayList;
import java.util.Date;

import model.Prenotazione;

public interface PrenotazioneDAO {

	public int save(Prenotazione prenotazione);
	
	public int update(Prenotazione prenotazione);
	public int updateData(int idPrenotazione, Date checkIn, Date checkOut);
	public int updateIdCamera(int idNuovaCamera,int idVecchiaCamera);
	//public int updateIntestatario(String idNuovoIntestatario, String idVecchioIntestatario);
	
	public int delete (int idPrenotazione);
	public int deletebyCamera(String camera);
	
	public Prenotazione get(int idPrenotazione);
	public Prenotazione getbyCamera(String camera);
	public Prenotazione getbyIntestatario(String intestatario);
	public ArrayList<Prenotazione> getbyEmail(String email);
	public ArrayList<Prenotazione> list();
	
	public Boolean checkDisponibilita(int Camera, Date checkIn, Date checkOut);
	
}
