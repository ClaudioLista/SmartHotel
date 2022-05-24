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

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("INSERT INTO camera(idCamera,numStanza,prenotabile,tipo,numPosti,dimensione,descrizione,prezzo) "
					+ "VALUES (?,?,?,?,?,?,?,?);");
			ps.setString(1, camera.getIdCamera());
			ps.setInt(2, camera.getNumStanza());
			ps.setBoolean(3, camera.isPrenotabile());
			ps.setString(4, camera.getTipo());
			ps.setInt(5, camera.getNumPosti());
			ps.setInt(6, camera.getDimensione());
			ps.setString(7, camera.getDescrizione());
			ps.setDouble(8, camera.getPrezzo());
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Camera camera) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE camera SET idCamera=?, numStanza=?, prenotabile=?, tipo=?, numPosti=?, dimensione=? "
					+ ", descrizione=?, prezzo=? WHERE idCamera=?;");
			ps.setString(1, camera.getIdCamera());
			ps.setInt(2, camera.getNumStanza());
			ps.setBoolean(3, camera.isPrenotabile());
			ps.setString(4, camera.getTipo());
			ps.setInt(5, camera.getNumPosti());
			ps.setInt(6, camera.getDimensione());
			ps.setString(7, camera.getDescrizione());
			ps.setDouble(8, camera.getPrezzo());
			
			int rs =ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int delete(String idCamera) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM camera WHERE idCamera=? ;");
			ps.setString(1, idCamera);
			
			int rs = ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deletebyNumStanza(int numStanza) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM camera WHERE numStanza=? ;");
			ps.setInt(1, numStanza);
			
			int rs = ps.executeUpdate();
			return rs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public ArrayList<Camera> list() {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("SELECT idCamera,numStanza,prenotabile,tipo,numPosti,dimensione,descrizione,prezzo FROM camera ;");
			ArrayList<Camera> listaUtente = new ArrayList<Camera>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Camera c = new Camera();

				c.setIdCamera(rs.getString(1));
				c.setNumStanza(rs.getInt(2));
				c.setPrenotabile(rs.getBoolean(3));
				c.setTipo(rs.getString(4));
				c.setNumPosti(rs.getInt(5));
				c.setDimensione(rs.getInt(6));
				c.setDescrizione(rs.getString(7));
				c.setPrezzo(rs.getDouble(8));

				listaUtente.add(c);
			}
			return listaUtente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updatePrezzo(int numCamera, double prezzo) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("UPDATE camera SET  prezzo=? WHERE numStanza=? ;");
			ps.setDouble(1, prezzo);
			ps.setInt(2, numCamera);

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Camera get(String idCamera) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("SELECT idCamera,numStanza,prenotabile,tipo,numPosti,dimensione,descrizione,prezzo "
					+ "FROM camera WHERE idCamera=?;");
			ps.setString(1, idCamera);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Camera c = new Camera();
				c.setIdCamera(rs.getString(1));
				c.setNumStanza(rs.getInt(2));
				c.setPrenotabile(rs.getBoolean(3));
				c.setTipo(rs.getString(4));
				c.setNumPosti(rs.getInt(5));
				c.setDimensione(rs.getInt(6));
				c.setDescrizione(rs.getString(7));
				c.setPrezzo(rs.getDouble(8));
				return c;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}	

	@Override
	public Camera getbyNumStanza(int numStanza) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("SELECT idCamera,numStanza,prenotabile,tipo,numPosti,dimensione,descrizione,prezzo "
					+ "FROM camera WHERE numStanza=?;");
			ps.setInt(1, numStanza);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Camera c = new Camera();
				c.setIdCamera(rs.getString(1));
				c.setNumStanza(rs.getInt(2));
				c.setPrenotabile(rs.getBoolean(3));
				c.setTipo(rs.getString(4));
				c.setNumPosti(rs.getInt(5));
				c.setDimensione(rs.getInt(6));
				c.setDescrizione(rs.getString(7));
				c.setPrezzo(rs.getDouble(8));
				return c;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

}
