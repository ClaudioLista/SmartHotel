package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;
import model.Utente;

public class UtenteDAOImpl implements UtenteDAO {
	
	
	// Save() Salva un nuovo utente nel database
		public synchronized int save(Utente utente) {
			PreparedStatement ps = null;

			try (Connection conn = DriverManagerConnectionPool.getConnection();) {
				ps = conn.prepareStatement(
						"insert into  utente(idUTENTE,email,password,nome,cognome,dataNascita,telefono,indirizzo,tipoUtente) values (?,?,?,?,?,?,?,?,?);");
				ps.setString(1, utente.getIdUtente());
				ps.setString(2, utente.getEmail());
				ps.setString(3, utente.getPassword());
				ps.setString(4, utente.getNome());
				ps.setString(5, utente.getCognome());
				ps.setString(6, utente.getCognome());
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
	
	// update() aggiorna il tipo di utente nel database
	public synchronized int update(String email, int tipo) {
		PreparedStatement ps = null;

		try (Connection conn = DriverManagerConnectionPool.getConnection();) {

		
			ps = conn.prepareStatement("Update Utente set  TipoUtente=? where email=?;");
			ps.setInt(1, tipo);
			ps.setString(2, email);
			int rs = ps.executeUpdate();
			return rs;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public void delete(String idUtente) {
		// TODO Auto-generated method stub

	}


	public ArrayList<Utente> list() {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement("select Email, Nome , Cognome, TipoUtente from Utente ;");
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Utente getbyID(String idUtente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente getbykey(String email, String password) {
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"select Email, Password, Nome , Cognome, TipoUtente from Utente Where Email=? AND Password=?;");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente p = new Utente();
				p.setEmail(rs.getString(1));
				p.setPassword(rs.getString(2));
				p.setNome(rs.getString(3));
				p.setCognome(rs.getString(4));
				p.setTipoUtente(rs.getInt(5));

				return p;
			}
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
