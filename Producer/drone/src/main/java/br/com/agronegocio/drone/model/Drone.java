package br.com.agronegocio.drone.model;

public class Drone {

	private int idDrone;

	private float latitude;

	private float longitude;

	private int temperaturaAr;

	private int umidadeAr;

	private boolean ativarRastreamento;

	

	public int getIdDrone() {
		return idDrone;
	}



	public void setIdDrone(int idDrone) {
		this.idDrone = idDrone;
	}



	public float getLatitude() {
		return latitude;
	}



	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}



	public float getLongitude() {
		return longitude;
	}



	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}



	public int getTemperaturaAr() {
		return temperaturaAr;
	}



	public void setTemperaturaAr(int temperaturaAr) {
		this.temperaturaAr = temperaturaAr;
	}



	public int getUmidadeAr() {
		return umidadeAr;
	}



	public void setUmidadeAr(int umidadeAr) {
		this.umidadeAr = umidadeAr;
	}



	public boolean isAtivarRastreamento() {
		return ativarRastreamento;
	}



	public void setAtivarRastreamento(boolean ativarRastreamento) {
		this.ativarRastreamento = ativarRastreamento;
	}



	public Drone(int idDrone, float latitude, float longitude, int temperaturaAr, int umidadeAr, boolean ativarRastreamento) {
		super();
		this.idDrone = idDrone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperaturaAr = temperaturaAr;
		this.umidadeAr = umidadeAr;
		this.ativarRastreamento = ativarRastreamento;
	}

}