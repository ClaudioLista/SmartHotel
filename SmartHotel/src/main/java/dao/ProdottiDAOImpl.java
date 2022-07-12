package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;
import model.Prodotto;
import model.Utente;

public class ProdottiDAOImpl implements ProdottiDAO {

	@Override
	public ArrayList<Prodotto> list() {
		PreparedStatement ps = null;
		
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			ps = con.prepareStatement("SELECT p.* FROM menu p;");
			ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prodotto p = new Prodotto();
				
				p.setIdProdotto(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setPrezzo(rs.getDouble(3));
				p.setQuantita(rs.getInt(5));
				p.setTipologia(rs.getString(4));

				listaProdotti.add(p);
			}
			
			return listaProdotti;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
