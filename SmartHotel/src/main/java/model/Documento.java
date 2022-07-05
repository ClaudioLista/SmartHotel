package model;

public class Documento {

	private int idDocumento;
	private String tipoDocumento;
	private String numeroDocumento;
	private String pathDocumento;
	private String emailIntestatario;
	public int getIdDocumento() {
		return idDocumento;
	}
	public Documento(int idDocumento, String tipoDocumento, String numeroDocumento, String pathDocumento,
			String emailIntestatario) {
		super();
		this.idDocumento = idDocumento;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.pathDocumento = pathDocumento;
		this.emailIntestatario = emailIntestatario;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getEmailIntestatario() {
		return emailIntestatario;
	}
	public void setEmailIntestatario(String emailIntestatario) {
		this.emailIntestatario = emailIntestatario;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getPathDocumento() {
		return pathDocumento;
	}
	public void setPathDocumento(String pathDocumento) {
		this.pathDocumento = pathDocumento;
	}
	public Documento(int idDocumento, String tipoDocumento, String numeroDocumento, String pathDocumento) {
		super();
		this.idDocumento = idDocumento;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.pathDocumento = pathDocumento;
	}
	
}
