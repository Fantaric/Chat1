package fi.meucci;

import java.net.*;
import java.io.*;

public class Serverstr {
    ServerSocket server = null;
    Socket client = null;
    String strRicevuta;
    String strModificata;

    public Socket avvia() throws IOException {

        ServerSocket server = new ServerSocket(6789);
        for (;;) {
            System.out.println("Server partito in esecuzione");
            client = server.accept();
            MioThread t1 = new MioThread(client);
            t1.start();
        }
    }

}
