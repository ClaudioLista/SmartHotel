package dao;

import java.util.ArrayList;
import java.util.Date;

import model.Camera;
import model.Prenotazione;

public class PrenotazioneDAOImpl implements PrenotazioneDAO {

	@Override
	public int save(Prenotazione prenotazione) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Prenotazione prenotazione) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateData(Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateIdCamera(String idNuovaCamera) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String idPrenotazione) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletebyNumStanza(int numStanza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prenotazione get(String idPrenotazione) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prenotazione> getbyNumStanza(int numStanza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prenotazione> getbyemailUtente(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prenotazione> list() {
		// TODO Auto-generated method stub
		return null;
	}


}
