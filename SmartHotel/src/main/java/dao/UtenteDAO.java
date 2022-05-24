package dao;

import java.util.ArrayList;

import model.Utente;

public interface UtenteDAO {
	public int save(Utente utente);
	
	public int update(String email, int tipo);
	public int updatePassword(String email, String password);
	
	public void delete (String idUtente);
	
	public Utente getbyID(String idUtente);
	public Utente getbyemail(String email);
	public Utente getbykey (String email, String password);
	
	public ArrayList<Utente> list();	
	
}
