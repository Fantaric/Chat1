package main.java.fi.meucci;

import java.io.*;
import java.net.*;

public class ThreadComunica extends Thread {

    Socket mySocket;
    String str = "";

    public ThreadComunica(Socket s) {
        this.mySocket = s;
    }

    public void exit(String str) {
        this.str = str;
    }

    public void comunica() throws IOException {
        try {
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Inserisci la stringa da trasmettere al server: ");

            while (true) {
                
                String stringaUtente = tastiera.readLine();

                if (stringaUtente.equals("FINE") || stringaUtente.equals("SPEGNI") || str.equals("SPEGNI")) {
                    out.writeBytes(stringaUtente + '\n');
                    return;
                }

                System.out.println("Invio la stringa al server e attendo");
                out.writeBytes(stringaUtente + '\n');
            }

        } catch (Exception e) {
            System.out.println("Errore di comunicazione");
        }
    }

    public void run() {
        try {
            comunica();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione con il server");
        }
    }

}
