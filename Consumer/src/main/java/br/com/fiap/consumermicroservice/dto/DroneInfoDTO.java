package br.com.fiap.consumermicroservice.dto;

public class DroneInfoDTO {

	private Long id;

	private String latitude;

	private String longitude;

	private int temperatura;

	private int umidade;

	public DroneInfoDTO(String message) {
		String[] fields = message.split(";");

		this.id = Long.parseLong(fields[0]);
		this.latitude = fields[1];
		this.longitude = fields[2];
		this.temperatura = Integer.parseInt(fields[3]);
		this.umidade = Integer.parseInt(fields[4]);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getUmidade() {
		return umidade;
	}

	public void setUmidade(int umidade) {
		this.umidade = umidade;
	}

	public boolean IsAlertMessage() {
		if ((this.temperatura >= 35 || this.getTemperatura() <= 0) || (this.getUmidade() <= 15)) {
			return true;
		}
		return false;
	}

}
