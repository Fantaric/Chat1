package fi.meucci;
import java.io.*;
import java.net.*;


public class Client2{
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket mySocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaServer;
    DataOutputStream out;
    BufferedReader in;

    public Socket connetti()
    {
        System.out.println("2 Client partito in esecuzione");

        try
        {
            mySocket = new Socket(nomeServer, portaServer);
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(mySocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));

        }
        catch(UnknownHostException e)
        {
            System.err.println("Host sconosciuto");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
            System.exit(1);;
        }
        return mySocket;
    }

    public void comunica()
    {
        try
        {
            System.out.println("Inserisci la stringa da trasmettere al server "+ '\n');
            stringaUtente = tastiera.readLine();

            System.out.println("Invio la stringa al server e attendo");
            out.writeBytes(stringaUtente + '\n');
            stringaServer = in.readLine();

            System.out.println("Risposta dal server: " +stringaServer + '\n');
            
            System.out.println(" Client: termina elaborazione e chiude la connessione");
            mySocket.close();
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione al server");
            System.exit(1);
        }

    }

}