package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Camera;
import model.DriverManagerConnectionPool;
import model.Prenotazione;
import model.Utente;

public class PrenotazioneDAOImpl implements PrenotazioneDAO {

	@Override	
	public synchronized int save(Prenotazione prenotazione) {
		PreparedStatement ps = null;
		
		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO prenotazione(idPrenotazione,dataPrenotazione,checkIn,checkOut,camera,intestatario,numOspiti) "
					+ "VALUES (?,?,?,?,?,?) ;");
			ps.setString(1, prenotazione.getIdPrenotazione());
			ps.setDate(2, (java.sql.Date) prenotazione.getDataPrenotazione());
			ps.setDate(3, (java.sql.Date) prenotazione.getCheckIn());
			ps.setDate(4, (java.sql.Date) prenotazione.getCheckOut());
			ps.setString(5, prenotazione.getCamera());
			ps.setString(6, prenotazione.getIntestatario());
			ps.setInt(7, prenotazione.getNumOspiti());
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized int update(Prenotazione prenotazione) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("UPDATE prenotazione SET idPrenotazione=?, dataPrenotazione=?, checkIn=?, checkOut=?, camera=?, "
					+ "intestatario=?, numOspiti=? WHERE idPrenotazione=? ;");
			ps.setString(1, prenotazione.getIdPrenotazione());
			ps.setDate(2, (java.sql.Date) prenotazione.getDataPrenotazione());
			ps.setDate(3, (java.sql.Date) prenotazione.getCheckIn());
			ps.setDate(4, (java.sql.Date) prenotazione.getCheckOut());
			ps.setString(5, prenotazione.getCamera());
			ps.setString(6, prenotazione.getIntestatario());
			ps.setInt(7, prenotazione.getNumOspiti());
			
			int rs =ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized int updateData(String idPrenotazione, Date checkIn, Date checkOut) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("UPDATE prenotazione SET checkIn=?, checkOut=? WHERE idPrenotazione = ? ;");
			ps.setDate(1, (java.sql.Date) checkIn);
			ps.setDate(2, (java.sql.Date) checkOut);
			ps.setString(3, idPrenotazione);
					
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized int updateIdCamera(String idNuovaCamera, String idVecchiaCamera)  {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("UPDATE prenotazione SET camera=? WHERE camera=? ;");
			ps.setString(1, idNuovaCamera);
			ps.setString(2, idVecchiaCamera);

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int delete(String idPrenotazione) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("DELETE FROM prenotazione WHERE idPrenotazione=? ;");
			ps.setString(1, idPrenotazione);
			
			int rs = ps.executeUpdate();
			return rs;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deletebyCamera(String camera) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("DELETE FROM prenotazione WHERE camera=? ;");
			ps.setString(1, camera);
			
			int rs = ps.executeUpdate();
			return rs;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Prenotazione get(String idPrenotazione) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			
			ps = con.prepareStatement("SELECT idPrenotazione,dataPrenotazione,checkIn,checkOut,camera,intestatario,numOspiti "
					+ "FROM prenotazione WHERE idPrenotazione=? ;");
			ps.setString(1, idPrenotazione);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Prenotazione p = new Prenotazione();
				
				p.setIdPrenotazione(rs.getString(1));
				p.setDataPrenotazione(rs.getDate(2));
				p.setCheckIn(rs.getDate(3));
				p.setCheckOut(rs.getDate(4));
				p.setCamera(rs.getString(5));
				p.setIntestatario(rs.getString(6));
				p.setNumOspiti(rs.getInt(7));

				return p;
			}
			
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Prenotazione getbyCamera(String camera) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			
			ps = con.prepareStatement("SELECT idPrenotazione,dataPrenotazione,checkIn,checkOut,camera,intestatario,numOspiti "
					+ "FROM prenotazione WHERE camera=? ;");
			ps.setString(1, camera);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Prenotazione p = new Prenotazione();
				
				p.setIdPrenotazione(rs.getString(1));
				p.setDataPrenotazione(rs.getDate(2));
				p.setCheckIn(rs.getDate(3));
				p.setCheckOut(rs.getDate(4));
				p.setCamera(rs.getString(5));
				p.setIntestatario(rs.getString(6));
				p.setNumOspiti(rs.getInt(7));

				return p;
			}
			
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Prenotazione getbyIntestatario(String intestatario) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			
			ps = con.prepareStatement("SELECT idPrenotazione,dataPrenotazione,checkIn,checkOut,camera,intestatario,numOspiti "
					+ "FROM prenotazione WHERE intestatario=? ;");
			ps.setString(1, intestatario);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Prenotazione p = new Prenotazione();
				
				p.setIdPrenotazione(rs.getString(1));
				p.setDataPrenotazione(rs.getDate(2));
				p.setCheckIn(rs.getDate(3));
				p.setCheckOut(rs.getDate(4));
				p.setCamera(rs.getString(5));
				p.setIntestatario(rs.getString(6));
				p.setNumOspiti(rs.getInt(7));

				return p;
			}
			
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Prenotazione> list() {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT idPrenotazione,dataPrenotazione,checkIn,checkOut,camera,intestatario,numOspiti FROM prenotazione ;");
			ArrayList<Prenotazione> listaPrenotazione = new ArrayList<Prenotazione>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prenotazione p = new Prenotazione();

				p.setIdPrenotazione(rs.getString(1));
				p.setDataPrenotazione(rs.getDate(2));
				p.setCheckIn(rs.getDate(3));
				p.setCheckOut(rs.getDate(4));
				p.setCamera(rs.getString(5));
				p.setIntestatario(rs.getString(6));
				p.setNumOspiti(rs.getInt(7));

				listaPrenotazione.add(p);
			}
			
			return listaPrenotazione;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
