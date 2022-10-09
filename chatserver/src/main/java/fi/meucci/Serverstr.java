package fi.meucci;

import java.net.*;
import java.io.*;


public class Serverstr {
    ServerSocket server = null;
    Socket client = null;
    String strRicevuta;
    String strModificata;
    BufferedReader in;
    DataOutputStream out;

    public void porta()
    {
        try
        {
            server = new ServerSocket(6789);

        } catch(Exception e)
        {
            System.out.println("Errore durante l'apertura della porta del server");
        }
       
    }
    public Socket attendi()
    {
        try
        {
            System.out.println("Server partito in esecuzione");
            client = server.accept();


            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());

        } catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }

    public void comunica()
    {
        try
        {
            System.out.println(" Benvenuto Client, scrivi una frase e la trasformo in maiuscolo");
            strRicevuta = in.readLine();
            System.out.println("Stringa ricevuta dal client: " +strRicevuta);

            strModificata = strRicevuta.toUpperCase();
            System.out.println("invio la stringa modificata al client");
            out.writeBytes(strModificata + '\n');

            System.out.println(" Server: fine elaborazione");
            client.close();
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione con il Client");
            System.exit(1);
        }
    }

}
