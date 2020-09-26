package br.com.fiap.consumermicroservice.dto;

public class DroneInfoDTO {

	private Long id;

	private Long latitude;

	private Long longitude;

	private int temperatura;

	private int umidade;

	public DroneInfoDTO(String message) {
		String[] fields = message.split(";");

		this.id = Long.parseLong(fields[0]);
		this.latitude = Long.parseLong(fields[1]);
		this.longitude = Long.parseLong(fields[2]);
		this.temperatura = Integer.parseInt(fields[3]);
		this.umidade = Integer.parseInt(fields[4]);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
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
