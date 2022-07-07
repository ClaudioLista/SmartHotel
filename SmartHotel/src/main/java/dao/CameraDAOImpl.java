package dao;

import java.util.ArrayList;

import model.Camera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;

public class CameraDAOImpl implements CameraDAO {

	@Override
	public synchronized int save(Camera camera) {
		PreparedStatement ps = null;
		
		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO camera(idCamera,tipo,numPosti,dimensione,prezzo,numCamera,prenotabile,descrizione) "
					+ "VALUES (?,?,?,?,?,?,?,?);");
			ps.setInt(1, camera.getIdCamera());
			ps.setString(2, camera.getTipo());
			ps.setInt(3, camera.getNumPosti());
			ps.setInt(4, camera.getDimensione());
			ps.setDouble(5, camera.getPrezzo());
			ps.setInt(6, camera.getNumCamera());
			ps.setBoolean(7, camera.isPrenotabile());
			ps.setString(8, camera.getDescrizione());
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized int update(Camera camera) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("UPDATE camera SET idCamera=?, tipo=?, numPosti=?, dimensione=?, prezzo=?, numCamera=?, prenotabile=?,  "
					+ "descrizione=? WHERE idCamera=?;");
			ps.setInt(1, camera.getIdCamera());
			ps.setString(2, camera.getTipo());
			ps.setInt(3, camera.getNumPosti());
			ps.setInt(4, camera.getDimensione());
			ps.setDouble(5, camera.getPrezzo());
			ps.setInt(6, camera.getNumCamera());
			ps.setBoolean(7, camera.isPrenotabile());
			ps.setString(8, camera.getDescrizione());
			
			int rs =ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized int updatePrezzo(int numStanza, double prezzo) {
		PreparedStatement ps = null;
		
		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("UPDATE camera SET  prezzo=? WHERE numStanza=? ;");
			ps.setDouble(1, prezzo);
			ps.setInt(2, numStanza);
			

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int delete(String idCamera) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("DELETE FROM camera WHERE idCamera=? ;");
			ps.setString(1, idCamera);
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deletebyNumCamera(int numCamera) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("DELETE FROM camera WHERE numCamera=? ;");
			ps.setInt(1, numCamera);
			
			int rs = ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Camera get(String idCamera) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			ps = con.prepareStatement("SELECT idCamera,tipo,numPosti,dimensione,prezzo,numCamera,prenotabile,descrizione FROM camera WHERE idCamera=?;");
			ps.setString(1, idCamera);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Camera c = new Camera();
				
				c.setIdCamera(rs.getInt(1));
				c.setTipo(rs.getString(2));
				c.setNumPosti(rs.getInt(3));
				c.setDimensione(rs.getInt(4));
				c.setPrezzo(rs.getDouble(5));
				c.setNumCamera(rs.getInt(6));
				c.setPrenotabile(rs.getBoolean(7));
				c.setDescrizione(rs.getString(8));
				
				return c;
			}
			
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	

	@Override
	public Camera getbyNumCamera(int numCamera) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			ps = con.prepareStatement("SELECT idCamera,tipo,numPosti,dimensione,prezzo,numCamera,prenotabile,descrizione FROM camera WHERE numCamera=? ;");
			ps.setInt(1, numCamera);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Camera c = new Camera();
				
				c.setIdCamera(rs.getInt(1));
				c.setTipo(rs.getString(2));
				c.setNumPosti(rs.getInt(3));
				c.setDimensione(rs.getInt(4));
				c.setPrezzo(rs.getDouble(5));
				c.setNumCamera(rs.getInt(6));
				c.setPrenotabile(rs.getBoolean(7));
				c.setDescrizione(rs.getString(8));
				
				return c;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
		
	}
	
	@Override
	public ArrayList<Camera> list() {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT idCamera,tipo,numPosti,dimensione,prezzo,numCamera,prenotabile,descrizione FROM camera ;");
			ArrayList<Camera> listaUtente = new ArrayList<Camera>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Camera c = new Camera();

				c.setIdCamera(rs.getInt(1));
				c.setTipo(rs.getString(2));
				c.setNumPosti(rs.getInt(3));
				c.setDimensione(rs.getInt(4));
				c.setPrezzo(rs.getDouble(5));
				c.setNumCamera(rs.getInt(6));
				c.setPrenotabile(rs.getBoolean(7));
				c.setDescrizione(rs.getString(8));

				listaUtente.add(c);
			}
			
			return listaUtente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateVisibilita(String idCamera, boolean prenotabile) {
		PreparedStatement ps = null;
		
		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("UPDATE camera SET  prenotabile=? WHERE idCamera=? ;");
			ps.setBoolean(1, prenotabile);
			ps.setString(2, idCamera);
			

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
