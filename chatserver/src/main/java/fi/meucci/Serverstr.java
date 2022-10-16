package fi.meucci;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Serverstr {
    ServerSocket server = null;
    Socket client = null;
    String strRicevuta;
    String strModificata;

    public Socket avvia() throws IOException {

        ServerSocket server = new ServerSocket(6789);
        ArrayList<MioThread> thread = new ArrayList<>();
        for (;;) {
            client = server.accept();
            MioThread t1 = new MioThread(client, thread, server);
            thread.add(t1);
            t1.start();

        }
    }

}
