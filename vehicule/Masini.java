package vehicule;

import java.util.ArrayList;

public class Masini extends Vehicle{
    private String marca;
    private String model;
    private static ArrayList<Masini> masina = new ArrayList<>();

    public Masini(String placutaInmatriculare, double nrKm, String marca, String model){
        super(placutaInmatriculare, nrKm);
        this.marca = marca;
        this.model = model;
    }

    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getModel(){
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static void addCar(Masini car) {
        masina.add(car);
    }

    public static int getSize() {
        return masina.size();
    }

    public static ArrayList<Masini> getAllCars() {
        return masina;
    }

    @Override

    public String toString(){
        return "Marca: " + marca + " " + "Model: " + model + " " + super.toString();
    }
}
