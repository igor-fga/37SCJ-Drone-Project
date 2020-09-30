package br.com.agronegocio.drone.model;

public class Drone {

	private int idDrone;

	private String latitude;

	private String longitude;

	private int temperaturaAr;

	private int umidadeAr;

	private boolean ativarRastreamento;

	public int getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(int idDrone) {
		this.idDrone = idDrone;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
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

	public Drone(int idDrone, String latitude, String longitude, int temperaturaAr, int umidadeAr,
			boolean ativarRastreamento) {
		super();
		this.idDrone = idDrone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperaturaAr = temperaturaAr;
		this.umidadeAr = umidadeAr;
		this.ativarRastreamento = ativarRastreamento;
	}

}