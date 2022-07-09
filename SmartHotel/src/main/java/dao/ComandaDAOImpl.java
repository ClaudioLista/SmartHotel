package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Comanda;
import model.DriverManagerConnectionPool;
import model.Prenotazione;
import model.Utente;

public class ComandaDAOImpl implements ComandaDAO {

	@Override
	public synchronized int save(Comanda comanda) {
		PreparedStatement ps = null;
		
		try (Connection conn = DriverManagerConnectionPool.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO comanda VALUES (?,?,?,?,?,?,?,?,?);");
			
			ps.setInt(1, comanda.getIdOrdine());
			ps.setInt(2, comanda.getIdPrenotazione());
			ps.setString(3, comanda.getIntestararioOrdine());
			ps.setString(4, comanda.getNumCamera());
			ps.setString(5, null);
			ps.setDate(6, Date.valueOf(comanda.getDataOrdine()));
			ps.setBoolean(7, false);
			ps.setString(8, comanda.getOrdine());
			ps.setDouble(9, comanda.getTotale());
				
			int rs = ps.executeUpdate();
			return rs;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Comanda> listAttive(String intestatario) {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT * FROM comanda where cliente = ? AND idPrenotazione IN (SELECT p.idPRENOTAZIONE FROM prenotazione p WHERE p.idPRENOTAZIONE = idPrenotazione AND p.checkInEffettuato = 1 AND p.checkOutEffettuato = 0);");
			ArrayList<Comanda> listaOrdini = new ArrayList<Comanda>();
			
			ps.setString(1, intestatario);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Comanda c = new Comanda();

				c.setIdOrdine(rs.getInt(1));
				c.setIdPrenotazione(rs.getInt(2));
				c.setIntestararioOrdine(rs.getString(3));
				c.setNumCamera(rs.getString(4));
				c.setDipendenteBar(rs.getString(5));
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				String strDate = dateFormat.format(rs.getDate(6));  
				
				c.setDataOrdine(strDate);
				c.setServito(rs.getBoolean(7));
				c.setOrdine(rs.getString(8));
				c.setTotale(rs.getDouble(9));

				listaOrdini.add(c);
			}
			
			return listaOrdini;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
}
