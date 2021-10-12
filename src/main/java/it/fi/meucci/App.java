package it.fi.meucci;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App 
{
    public static void main( String[] args )
    {
        
        String ipserver = "localhost";  //ip del server con cui comunicare (localhost = 127.0.0.1, la comunicazione è interna)
        int port = 5000;                //deve essere maggiore di 1023
        
        ClientThread c = new ClientThread(new Cliente(ipserver, port, "ciao"));
        ClientThread c1 = new ClientThread(new Cliente(ipserver, port, "fine"));
        ClientThread c2 = new ClientThread(new Cliente(ipserver, port, "stop"));
        ClientThread c3 = new ClientThread(new Cliente(ipserver, port, "ccccccccbbb"));  
        ClientThread c4 = new ClientThread(new Cliente(ipserver, port, "aaaaaaabbb"));
        
        //Non facendo dei thread anche per i client, i client creati richiederebbero servizio al server uno per volta
        c.start();
        //c1.start();
        //c2.start();
        //c3.start();
        //c4.start();
        
    }
}
