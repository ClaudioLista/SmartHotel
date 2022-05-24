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
	
	
	// Save Salva un nuovo utente nel database
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

	public int update(Utente utente) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(String idUtente) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM utente WHERE idUTENTE=?;");
			ps.setString(1, idUtente);
			
			int rs = ps.executeUpdate();
			return rs;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public ArrayList<Utente> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePassword(String email, String password) {
		int rs = 0;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE utente SET  password=?  WHERE email =?;");
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
			PreparedStatement ps = con.prepareStatement(
					"select email, password, nome , cognome, dataNascita, telefono, indirizzo, tipoUtente from utente Where email=? AND password=?;");
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
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Utente getbyemail(String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select email, password, nome , cognome, dataNascita, telefono, indirizzo, tipoUtente from utente Where email=? AND password=?;");
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente p = new Cliente();
				p.setIdUtente(rs.getString(1));
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
	public Utente getbykey(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
