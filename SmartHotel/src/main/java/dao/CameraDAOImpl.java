package dao;

import java.util.ArrayList;

import model.Camera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;
public class CameraDAOImpl implements CameraDAO {

	@Override
	public synchronized int save(Camera camera) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement(
					"insert into  camera(idCAMERA,numStanza,prenotabile,tipo,numPosti,dimensione,descrizione,prezzo) values (?,?,?,?,?,?,?,?);");
			ps.setString(1, camera.getIdCamera());
			ps.setInt(2, camera.getNumStanza());
			ps.setBoolean(3, camera.isPrenotabile());
			ps.setString(4, camera.getTipo());
			ps.setInt(5, camera.getNumOspiti());
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String idCamera) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Camera> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePrezzo(double prezzo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletebyNumStanza(int numStanza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Camera get(String idCamera) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Camera getbyNumStanza(int numStanza) {
		// TODO Auto-generated method stub
		return null;
	}

}
