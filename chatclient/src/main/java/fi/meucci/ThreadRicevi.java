package main.java.fi.meucci;

import java.io.*;
import java.net.*;

public class ThreadRicevi extends Thread {

    Socket mySocket;
    ThreadComunica c;
    
    public ThreadRicevi(Socket s, ThreadComunica c) {
        this.mySocket = s;
        this.c = c;
    }

    public void ricevi() throws IOException {
        
        while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            String stringaServer = in.readLine();

            if(stringaServer.equals("FINE")){
                mySocket.close();
                System.out.println("Socket chiuso, termina la connessione di questo client");
                return;
            }
           
            if (stringaServer.equals("SPEGNI")){
                System.out.println("Chiusi tutti i socket e la porta del server");
                c.exit(stringaServer);
                return;
            }
            System.out.println("Risposta dal server: " + stringaServer + '\n');
        }
    }

    public void run() {
        try {
            ricevi();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la ricezione da parte del Client");
        }
    }
}
