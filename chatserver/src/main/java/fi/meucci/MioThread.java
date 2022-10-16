package fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MioThread extends Thread {

    ServerSocket server;
    Socket client;
    ArrayList<MioThread> thread;

    public MioThread(Socket client, ArrayList<MioThread> thread, ServerSocket server) {
        this.client = client;
        this.thread = thread;
        this.server = server;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
        try {
            comunica();
        } catch (Exception e) {
            System.out.println("errore");
        }

    }

    public void comunica() throws IOException {

        for (;;) {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String strRicevuta = in.readLine();

            String strModificata = strRicevuta.toUpperCase();
            out.writeBytes(strModificata + '\n');

            if (strModificata.equals("SPEGNI")) {
                for (MioThread mioThread : thread) {
                    mioThread.client.close();
                }
                server.close();
            }

        }

    }
}
