package dao;

import model.Camera;
import model.Documento;

public interface DocumentoDao {

	
	public int save(Documento documento);
	public Documento get(int idDocumenyto);
	
}
