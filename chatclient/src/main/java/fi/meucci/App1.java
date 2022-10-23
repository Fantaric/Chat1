package fi.meucci;

import main.java.fi.meucci.ThreadComunica;
import main.java.fi.meucci.ThreadRicevi;
import java.io.*;
import java.net.*;

public class App1 {
    public static void main(String[] args) {
        Socket mysocket;
        Client2 client = new Client2();
        try {
            mysocket = client.connetti();
            ThreadComunica tCom = new ThreadComunica(mysocket);
            Thread tRic = new ThreadRicevi(mysocket, tCom);
            tCom.start();
            tRic.start();
            
        } catch (Exception e) {
            System.out.println("errore durante la connessione");
        }

    }
}
