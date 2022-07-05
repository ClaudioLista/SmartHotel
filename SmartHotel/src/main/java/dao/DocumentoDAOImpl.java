package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Documento;
import model.DriverManagerConnectionPool;

public class DocumentoDAOImpl implements DocumentoDao {

	@Override
	public int save(Documento documento) {
PreparedStatement ps = null;
		
		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO documento(IdDocumento,TipoDocumento,NumeroDocumento,IntestatarioDocumento,PathDocumento) "
					+ "VALUES (?,?,?,?,?);");
			ps.setInt(1, documento.getIdDocumento());
			ps.setString(2, documento.getTipoDocumento());
			ps.setString(3, documento.getNumeroDocumento());
			ps.setString(4, documento.getEmailIntestatario());
			ps.setString(5, documento.getPathDocumento());
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Documento get(int idDocumento) {
		
		return null;
	}

}
