package vehicule;

public class MasiniElectrice extends Masini implements Incarcare{
    private int nivelBaterie;

    public MasiniElectrice(String placutaInmatriculare, double nrKm, String marca, String model, int nivelBaterie){
        super(placutaInmatriculare, nrKm, marca, model);
        this.nivelBaterie = nivelBaterie;
    }

    public int getBaterie(){
        return nivelBaterie;
    }

    public void setBaterie(int nivelBaterie) {
        this.nivelBaterie = nivelBaterie;
    }

    @Override
    public String refillOrRecharge() {
        return "Sanatate baterie 100%!";
    }

    @Override
    public String toString(){
        return "Vehicul Electric" + " " + super.toString() + " " + "Nivel Baterie" + nivelBaterie;
    }

    @Override
    public void incarcare() {
        this.nivelBaterie = 100;
        LoggerSingleton.getInstance().log("The electric car is now charged.");
    }
    
}