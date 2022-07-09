package dao;

import java.util.ArrayList;

import model.Comanda;
import model.Utente;

public interface ComandaDAO {

	public int save(Comanda comanda);
	public ArrayList<Comanda> listAttive(String intestatario);
	ArrayList<Comanda> listNonServiti();
	int update(int idComanda, String addettoBar);
	
}
