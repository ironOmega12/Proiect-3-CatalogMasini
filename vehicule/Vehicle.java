package vehicule;

public abstract class Vehicle {
    private String placutaInmatriculare;
    private double nrKm;

    public Vehicle(String placutaInmatriculare, double nrKm) {
        this.placutaInmatriculare = placutaInmatriculare;
        this.nrKm = nrKm;
    }

    public String getPlacuta() {
        return placutaInmatriculare;
    }

    public void setPlacuta(String placutaInmatriculare) {
        this.placutaInmatriculare = placutaInmatriculare;
    }

    public double getKm() {
        return nrKm;
    }

    public void setKm(double nrKm) {
        this.nrKm = nrKm;
    }

    @Override
    public String toString() {
        return "Placuta Inmatriculare: " + placutaInmatriculare + " " + "Numar Kilometri: " + " " + nrKm;
    }

}
