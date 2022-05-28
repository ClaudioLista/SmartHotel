package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.PrenotazioneDAO;
import model.Camera;
import model.DriverManagerConnectionPool;
import model.Prenotazione;
import model.Utente;
import java.util.Date; 
import java.text.SimpleDateFormat;

public class PrenotazioneDAOImpl implements PrenotazioneDAO {

	@Override	
	public synchronized int save(Prenotazione prenotazione) {
		PreparedStatement ps = null;
		
		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO prenotazione(idPrenotazione,dataPrenotazione,checkIn,checkOut,camera,intestatario,numOspiti) "
					+ "VALUES (?,?,?,?,?,?) ;");
			ps.setInt(1, prenotazione.getIdPrenotazione());
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
			ps.setInt(1, prenotazione.getIdPrenotazione());
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
	public synchronized int updateData(int idPrenotazione, Date checkIn, Date checkOut) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("UPDATE prenotazione SET checkIn=?, checkOut=? WHERE idPrenotazione = ? ;");
			ps.setDate(1, (java.sql.Date) checkIn);
			ps.setDate(2, (java.sql.Date) checkOut);
			ps.setInt(3, idPrenotazione);
					
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized int updateIdCamera(int idNuovaCamera, int idVecchiaCamera)  {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("UPDATE prenotazione SET camera=? WHERE camera=? ;");
			ps.setInt(1, idNuovaCamera);
			ps.setInt(2, idVecchiaCamera);

			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int delete(int idPrenotazione) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("DELETE FROM prenotazione WHERE idPrenotazione=? ;");
			ps.setInt(1, idPrenotazione);
			
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
	public Prenotazione get(int idPrenotazione) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			
			ps = con.prepareStatement("SELECT idPrenotazione,dataPrenotazione,checkIn,checkOut,camera,intestatario,numOspiti "
					+ "FROM prenotazione WHERE idPrenotazione=? ;");
			ps.setInt(1, idPrenotazione);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Prenotazione p = new Prenotazione();
				
				p.setIdPrenotazione(rs.getInt(1));
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
				
				p.setIdPrenotazione(rs.getInt(1));
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
				
				p.setIdPrenotazione(rs.getInt(1));
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
	
	// Ricerca prenotazioni per data 
		@Override
		public ArrayList<Prenotazione> getbyDate(String email) {
				try (Connection con = DriverManagerConnectionPool.getConnection()) {
					PreparedStatement ps = con.prepareStatement(
							"select idPrenotazione,dataPrenotazione,checkIn,checkOut,camera,intestatario,numOspiti"
							+ " FROM prenotazione JOIN utente  on  intestatario = email where email=? AND ( dataPrenotazione BETWEEN ? and ? )order by  dataPrenotazione Desc ;");
					ps.setString(1, email);
					
					GetTodayDate gtd = new GetTodayDate();
					
					System.out.println(gtd.main());
					// qua passiamo la data corrente
					ps.setString(2, "1975-01-01");
					ps.setString(3,gtd.main());

					ArrayList<Prenotazione> prenotazioniData = new ArrayList<>();
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Prenotazione p = new Prenotazione();

						//TENTATIVO : data inizialmente passata come stringa, ma poi l'ho passata tramite Date
						//Date data_prenot= new SimpleDateFormat("dd/MM/yyyy").parse(data);
//						SimpleDateFormat data_formatter =new SimpleDateFormat("dd/MM/yyyy");  
//						Date data_prenot = data_formatter.parse(data);
						
						p.setIdPrenotazione(rs.getInt(1));
						p.setDataPrenotazione(rs.getDate(2));
						p.setCheckIn(rs.getDate(3));
						p.setCheckOut(rs.getDate(4));
						p.setCamera(rs.getString(5));
						p.setIntestatario(rs.getString(6));
						p.setNumOspiti(rs.getInt(7));

						prenotazioniData.add(p);
						
					}
					return prenotazioniData;
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

				p.setIdPrenotazione(rs.getInt(1));
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
