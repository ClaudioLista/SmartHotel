package dao;

import java.util.ArrayList;

import model.Camera;

public interface CameraDAO {

	public int save(Camera camera);
	
	public int update(Camera camera);
	public int updatePrezzo(int numCamera, double prezzo);
	
	public int delete (String idCamera);
	public int deletebyNumCamera(int numCamera);
	
	public Camera get(String idCamera);
	public Camera getbyNumCamera(int numCamera);
	
	public ArrayList<Camera> list();
	
}
