package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;
import model.Utente;

public class UtenteDAOImpl implements UtenteDAO {
	
	@Override
	public synchronized int save(Utente utente) {
		PreparedStatement ps = null;
		
		System.out.println("UtenteDAO SAVE");
		
		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO  utente(email,password,nome,cognome,dataNascita,telefono,indirizzo,tipoUtente) "
					+ "VALUES (?,?,?,?,?,?,?,?);");
			ps.setString(1, utente.getEmail());
			ps.setString(2, utente.getPassword());
			ps.setString(3, utente.getNome());
			ps.setString(4, utente.getCognome());
			ps.setDate(5, utente.getDataNascita());
			ps.setString(6, utente.getTelefono());
			ps.setString(7, utente.getIndirizzo());
			ps.setInt(8, utente.getTipoUtente());
				
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public synchronized int updateTipo(String email, int tipoUtente) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("UPDATE utente SET tipoUtente=? WHERE email=? ;");
			ps.setInt(1, tipoUtente);
			ps.setString(2, email);
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized int updatePassword(String email, String newPassword) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("UPDATE utente SET  password=?  WHERE email =? ;");
			ps.setString(1, newPassword);
			ps.setString(2, email);
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public synchronized int updateDati(String email, String newIndirizzo, String newTelefono){
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("UPDATE utente SET  indirizzo=?, telefono=?  WHERE email =? ;");
			ps.setString(1, newIndirizzo);
			ps.setString(2, newTelefono);
			ps.setString(3, email);
			
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public int delete(String idUtente) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("DELETE FROM utente WHERE idUtente=? ;");
			ps.setString(1, idUtente);
			
			int rs = ps.executeUpdate();
			return rs;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Utente getbyID(String idUtente) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT idUtente,email,password,nome,cognome,dataNascita,telefono,indirizzo,tipoUtente "
					+ "FROM utente WHERE idUtente=? ;");
			ps.setString(1, idUtente);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				
				p.setIdUtente(rs.getInt(1));
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
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Utente getbyEmail(String email) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT idUtente,email,password,nome,cognome,dataNascita,telefono,indirizzo,tipoUtente "
					+ "FROM utente WHERE email=? ;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				
				p.setIdUtente(rs.getInt(1));
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
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Utente getbyKey(String email, String password) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT idUtente,email,password,nome,cognome,dataNascita,telefono,indirizzo,tipoUtente "
					+ "FROM utente WHERE email=? AND password=?;");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				
				System.out.println("utente trovato");
				
				p.setIdUtente(rs.getInt(1));
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
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Utente> list() {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT idUtente,email,password,nome,cognome,dataNascita,telefono,indirizzo,tipoUtente FROM utente ;");
			ArrayList<Utente> listaUtente = new ArrayList<Utente>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente p = new Utente();
				
				p.setIdUtente(rs.getInt(1));
				p.setEmail(rs.getString(2));
				p.setPassword(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setCognome(rs.getString(5));
				p.setDataNascita(rs.getDate(6));
				p.setTelefono(rs.getString(7));
				p.setIndirizzo(rs.getString(8));
				p.setTipoUtente(rs.getInt(9));

				listaUtente.add(p);
			}
			
			return listaUtente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public ArrayList<Utente> listClienti() {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT idUtente,email,password,nome,cognome,dataNascita,telefono,indirizzo,tipoUtente FROM utente WHERE tipoUtente = 1;");
			ArrayList<Utente> listaUtente = new ArrayList<Utente>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente p = new Utente();
				
				p.setIdUtente(rs.getInt(1));
				p.setEmail(rs.getString(2));
				p.setPassword(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setCognome(rs.getString(5));
				p.setDataNascita(rs.getDate(6));
				p.setTelefono(rs.getString(7));
				p.setIndirizzo(rs.getString(8));
				p.setTipoUtente(rs.getInt(9));

				listaUtente.add(p);
			}
			
			return listaUtente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
