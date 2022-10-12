package fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread {

    Socket client = null;

    public MioThread(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            comunica();
        } catch (Exception e) {
            System.out.println("errore");
        }

    }

    public void comunica() throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        String strRicevuta = in.readLine();
        String strModificata = strRicevuta.toUpperCase();
        out.writeBytes(strModificata + '\n');
        client.close();
    }
}
