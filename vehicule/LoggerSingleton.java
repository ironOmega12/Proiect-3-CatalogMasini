package vehicule;

public class LoggerSingleton {
    private static LoggerSingleton instance;

    private LoggerSingleton() {}

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void log(String mesaj) {
        System.out.println("[LOG]: " + mesaj);
    }
}
