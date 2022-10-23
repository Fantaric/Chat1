package fi.meucci;

import java.io.*;
import java.net.*;

public class Client2 {

    public Socket connetti() throws IOException {
        System.out.println("Client partito in esecuzione");

        Socket mySocket = new Socket("localhost", 6789);
        return mySocket;
    }
}
