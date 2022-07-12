package model;

public class Prodotto {

	private int idProdotto;
	private String nome;
	private String tipologia;
	private double prezzo;
	private int quantita;
	public int getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public Prodotto(int idProdotto, String nome, String tipologia, int prezzo, int quantita) {
		super();
		this.idProdotto = idProdotto;
		this.nome = nome;
		this.tipologia = tipologia;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}
	public Prodotto() {
		// TODO Auto-generated constructor stub
	}
	
}
