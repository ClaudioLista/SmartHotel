package dao;

import java.util.ArrayList;

import model.Utente;

public interface UtenteDAO {
	
	public int save(Utente utente);
	
	public int updateTipo(String email, int tipoUtente);
	public int updatePassword(String email, String newPassword);
	
	public int delete (String idUtente);
	
	public Utente getbyID(String idUtente);
	public Utente getbyEmail(String email);
	public Utente getbyKey(String email, String password);
	
	public ArrayList<Utente> list();	
	public ArrayList<Utente> listClienti();
	
}
