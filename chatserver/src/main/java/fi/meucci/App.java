package fi.meucci;

public class App {
    public static void main(String[] args) {
        Serverstr server = new Serverstr();
        try {
            server.avvia();
        } catch (Exception e) {
            System.out.println("Errore durante l'avvio del server");
        }

    }
}
