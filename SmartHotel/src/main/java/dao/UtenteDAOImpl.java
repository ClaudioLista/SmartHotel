package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Cliente;
import model.DriverManagerConnectionPool;
import model.Utente;

public class UtenteDAOImpl implements UtenteDAO {
	
	
	@Override
	public synchronized int save(Utente utente) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {
			ps = conn.prepareStatement("INSERT INTO  utente(idUtente,email,password,nome,cognome,dataNascita,telefono,indirizzo,tipoUtente) "
					+ "VALUES (?,?,?,?,?,?,?,?,?);");
			ps.setString(1, utente.getIdUtente());
			ps.setString(2, utente.getEmail());
			ps.setString(3, utente.getPassword());
			ps.setString(4, utente.getNome());
			ps.setString(5, utente.getCognome());
			ps.setDate(6, (Date) utente.getDataNascita());
			ps.setString(7, utente.getTelefono());
			ps.setString(8, utente.getIndirizzo());
			ps.setInt(9, utente.getTipoUtente());
				
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override //Aggiorna il tipo di utente nel database
	public synchronized int update(String email, int tipo) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {

			ps = conn.prepareStatement("UPDATE utente SET tipoUtente=? WHERE email=? ;");
			ps.setInt(1, tipo);
			ps.setString(2, email);
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String idUtente) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM utente WHERE idUtente=? ;");
			ps.setString(1, idUtente);
			
			int rs = ps.executeUpdate();
			return rs;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public ArrayList<Utente> list() {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("SELECT email, nome , cognome, tipoUtente FROM utente ;");
			ArrayList<Utente> listaUtente = new ArrayList<Utente>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente p = new Utente();

				p.setEmail(rs.getString(1));
				p.setNome(rs.getString(2));
				p.setCognome(rs.getString(3));
				p.setTipoUtente(rs.getInt(4));

				listaUtente.add(p);
			}
			return listaUtente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updatePassword(String email, String password) {
		int rs = 0;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE utente SET  password=?  WHERE email =? ;");
			ps.setString(2, email);
			ps.setString(3, password);
			
			rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Utente getbyID(String idUtente) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT email, password, nome , cognome, dataNascita, telefono, indirizzo, tipoUtente "
					+ "FROM utente WHERE idUtente=? ;");
			ps.setString(1, idUtente);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente p = new Cliente();
				p.setEmail(rs.getString(2));
				p.setPassword(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setCognome(rs.getString(5));
				p.setDataNascita(rs.getDate(6));
				p.setTelefono(rs.getString(7));
				p.setIndirizzo(rs.getString(8));
				p.setTipoUtente(rs.getInt(9));

				return p;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public Utente getbyEmail(String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT email, password, nome , cognome, dataNascita, telefono, indirizzo, tipoUtente "
					+ "FROM utente WHERE email=? ");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente p = new Cliente();
				p.setEmail(rs.getString(1));
				p.setPassword(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setCognome(rs.getString(5));
				p.setDataNascita(rs.getDate(6));
				p.setTelefono(rs.getString(7));
				p.setIndirizzo(rs.getString(8));
				p.setTipoUtente(rs.getInt(9));

				return p;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public Utente getbyKey(String email, String password) {
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("SELECT email, password, nome , cognome, dataNascita, telefono, indirizzo, tipoUtente "
					+ "FROM utente WHERE email=? AND password=?;");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente p = new Utente();
				p.setEmail(rs.getString(1));
				p.setPassword(rs.getString(2));
				p.setNome(rs.getString(3));
				p.setCognome(rs.getString(4));
				p.setDataNascita(rs.getDate(6));
				p.setTelefono(rs.getString(7));
				p.setIndirizzo(rs.getString(8));
				p.setTipoUtente(rs.getInt(9));

				return p;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
