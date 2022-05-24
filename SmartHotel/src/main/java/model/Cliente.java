package model;

import java.util.Date;

public class Cliente extends Utente {

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String idUtente, String email, String password, String nome, String cognome, Date dataNascita,
			String telefono, String indirizzo, int tipoUtente) {
		super(idUtente, email, password, nome, cognome, dataNascita, telefono, indirizzo, tipoUtente);
		// TODO Auto-generated constructor stub
	}

}