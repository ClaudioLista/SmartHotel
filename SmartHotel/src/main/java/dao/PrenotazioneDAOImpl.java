package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.DriverManagerConnectionPool;
import model.Prenotazione;

public class PrenotazioneDAOImpl implements PrenotazioneDAO {

	@Override	
	public synchronized int save(Prenotazione prenotazione) {
		PreparedStatement ps = null;
		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement(
					"INSERT INTO Prenotazione(idPRENOTAZIONE,dataPrenotazione,checkIn,checkOut,camera,intestatario) VALUES (?,?,?,?,?,?);");
			ps.setString(1, prenotazione.getIdPrenotazione());
			ps.setDate(2, (java.sql.Date) prenotazione.getDataPrenotazione());
			ps.setDate(3, (java.sql.Date) prenotazione.getCheckIn());
			ps.setDate(4, (java.sql.Date) prenotazione.getCheckOut());
			ps.setString(5, prenotazione.getCamera().getIdCamera());
			ps.setString(6, prenotazione.getIntestatario().getIdUtente());
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Prenotazione prenotazione) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateData(Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateIdCamera(String idNuovaCamera, String idVecchiaCamera)  {
			PreparedStatement ps = null;

			try (Connection conn = DriverManagerConnectionPool.getConnection();) {
				ps = conn.prepareStatement("UPDATE PRENOTAZIONE set  camera=? where camera=? ;");
				ps.setString(1, idNuovaCamera);
				ps.setString(2, idVecchiaCamera);

				int rs = ps.executeUpdate();
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}

	@Override
	public void delete(String idPrenotazione) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletebyNumStanza(int numStanza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prenotazione get(String idPrenotazione) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("select idPRENOTAZIONE,dataPrenotazione,checkIn,checkOut,camera,intestatario from prenotazione Where idPRENOTAZIONE=? ;");
			ps.setString(1, idPrenotazione);
			ResultSet rs = ps.executeQuery();
			ArrayList<Prenotazione> listaPrenotazione = new ArrayList<Prenotazione>();
			
			Prenotazione p = new Prenotazione();
			
			while (rs.next()) {

				p.setIdPrenotazione(rs.getString(1));
				p.setDataPrenotazione(rs.getDate(2));
				p.setCheckIn(rs.getDate(3));;
				p.setCheckOut(rs.getDate(4));
				p.setCameraId(rs.getString(5));
				//p.setIntestatario(rs.getString(6));

				listaPrenotazione.add(p);
			}

			return p;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Prenotazione> getbyIdCamera(String IdCamera) {
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("select idPRENOTAZIONE,dataPrenotazione,checkIn,checkOut,camera,intestatario from prenotazione Where camera=? ;");
			ps.setString(1, IdCamera);
			ResultSet rs = ps.executeQuery();
			ArrayList<Prenotazione> listaPrenotazione = new ArrayList<Prenotazione>();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();

				p.setIdPrenotazione(rs.getString(1));
				p.setDataPrenotazione(rs.getDate(2));
				p.setCheckIn(rs.getDate(3));;
				p.setCheckOut(rs.getDate(4));
				//p.setCamera(rs.getString(5));
				//p.setIntestatario(rs.getString(6));

				listaPrenotazione.add(p);
			}
			return listaPrenotazione;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Prenotazione> getbyemailUtente(String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("select idPRENOTAZIONE,dataPrenotazione,checkIn,checkOut,camera,intestatario from prenotazione Where email=? ;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			ArrayList<Prenotazione> listaPrenotazione = new ArrayList<Prenotazione>();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();

				p.setIdPrenotazione(rs.getString(1));
				p.setDataPrenotazione(rs.getDate(2));
				p.setCheckIn(rs.getDate(3));;
				p.setCheckOut(rs.getDate(4));
				p.setCameraId(rs.getString(5));
				//p.setIntestatario(rs.getString(6));

				listaPrenotazione.add(p);
			}
			return listaPrenotazione;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Prenotazione> list() {
		// TODO Auto-generated method stub
		return null;
	}


}
