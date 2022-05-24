package dao;

import java.util.ArrayList;
import java.util.List;

import model.Utente;

public interface UtenteDAO {
	public int save(Utente utente);
	
	public int update(Utente utente);
	public int updatePassword(String email, String password);
	
	public int delete (String idUtente);
	
	public Utente getbyID(String idUtente);
	public Utente getbyemail(String email);
	public Utente getbykey (String email, String password);
	
	public ArrayList<Utente> list();	
	
}
