package fi.meucci;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MioThread extends Thread {

    ServerSocket server;
    Socket client;
    ArrayList<Socket> S;

    public MioThread(Socket client, ArrayList<Socket> S, ServerSocket server) {
        this.client = client;
        this.S = S;
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
                for (Socket sock : S) {
                    sock.close();
                }
                server.close();
            }
            if(strModificata.equals("FINE")){
                client.close();
                break;
            }

        }

    }
}
