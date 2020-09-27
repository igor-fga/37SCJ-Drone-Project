package br.com.agronegocio.drone.model;


public class Drone {


    private int Id;


    private  float latitude;


    private  float longitude;


    private double temperaturaAr;


    private double umidadeAr;


    private boolean ativarRastreamento;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public double getTemperaturaAr() {
        return temperaturaAr;
    }

    public void setTemperaturaAr(double temperaturaAr) {
        this.temperaturaAr = temperaturaAr;
    }

    public double getUmidadeAr() {
        return umidadeAr;
    }

    public void setUmidadeAr(double umidadeAr) {
        this.umidadeAr = umidadeAr;
    }

    public boolean isAtivarRastreamento() {
        return ativarRastreamento;
    }

    public void setAtivarRastreamento(boolean ativarRastreamento) {
        this.ativarRastreamento = ativarRastreamento;
    }


    public Drone() {


    }

    public Drone(float latitude, float longitude, double temperaturaAr, double umidadeAr, boolean ativarRastreamento) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperaturaAr = temperaturaAr;
        this.umidadeAr = umidadeAr;
        this.ativarRastreamento = ativarRastreamento;
    }




}