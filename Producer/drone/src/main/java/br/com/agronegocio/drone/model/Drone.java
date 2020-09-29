package br.com.agronegocio.drone.model;

public class Drone {

	private int idDrone;

	private float latitude;

	private float longitude;

	private double temperaturaAr;

	private double umidadeAr;

	private boolean ativarRastreamento;

	public int getIdDrone() {
		return idDrone;
	}


	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public double getTemperaturaAr() {
		return temperaturaAr;
	}

	public double getUmidadeAr() {
		return umidadeAr;
	}

	public boolean isAtivarRastreamento() {
		return ativarRastreamento;
	}

	public void setAtivarRastreamento(boolean ativarRastreamento) {
		this.ativarRastreamento = ativarRastreamento;
	}

	public Drone(int idDrone, float latitude, float longitude, double temperaturaAr, double umidadeAr, boolean ativarRastreamento) {
		super();
		this.idDrone = idDrone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperaturaAr = temperaturaAr;
		this.umidadeAr = umidadeAr;
		this.ativarRastreamento = ativarRastreamento;
	}

}