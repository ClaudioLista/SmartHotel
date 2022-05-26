package model;

import java.sql.Date;

public class Utente {
		
	private int idUtente;
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String telefono;
	private String indirizzo;
	private int tipoUtente;

	public Utente() {
		
	}
		
	public Utente(int idUtente, String email, String password, String nome, String cognome, Date dataNascita,
				String telefono, String indirizzo, int tipoUtente) {
		this.idUtente = idUtente;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.tipoUtente = tipoUtente;
	}
		
	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", email=" + email + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome 
				+ ", dataNascita=" + dataNascita + ", telefono=" + telefono + ", indirizzo=" + indirizzo + ", tipoUtente=" + tipoUtente + "]";
	}
		
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getTipoUtente() {
		return tipoUtente;
	}
	public void setTipoUtente(int tipoUtente) {
		this.tipoUtente = tipoUtente;
	}
	
}
