package model;
import model.Camera;

public class CameraDisponibile {
    public  Camera CameraDisp;
    public  int disponibilita;
    
    
    
	public Camera getListaCamere() {
		return CameraDisp;
	}



	public void setListaCamere(Camera newCamera) {
		CameraDisp = newCamera;
	}



	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}



	public int getDisponibilita() {
		return disponibilita;
	}
}