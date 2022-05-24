package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


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

	public int update(Utente utente) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(String idUtente) {
		// TODO Auto-generated method stub

	}


	public ArrayList<Utente> list() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
