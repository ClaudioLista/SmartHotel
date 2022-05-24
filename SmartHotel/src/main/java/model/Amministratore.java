package model;

import java.util.Date;

public class Amministratore extends Utente{

	public Amministratore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amministratore(String idUtente, String email, String password, String nome, String cognome, Date dataNascita,
			String telefono, String indirizzo, int tipoUtente) {
		super(idUtente, email, password, nome, cognome, dataNascita, telefono, indirizzo, tipoUtente);
		// TODO Auto-generated constructor stub
	}

}
