import interfata.*;
import vehicule.*;
public class Main {
    public static void main(String[] args) {
        Masini masina1 = new Masini("AB69", 200, "BMW", "Seria3");
        System.out.println(masina1.toString());
        new CatalogMasiniUI();
    }
}
