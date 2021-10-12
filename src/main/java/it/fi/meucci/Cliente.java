package it.fi.meucci;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Metodo che fa partire il client per farlo comunicare con un server.
 * Il client manderà e riceverà un messaggio da un server.
 * @author Dardan Matias Berisha
 */
public class Cliente {
    
    protected String ipServer = "";     //indirizzo ip del server
    protected int portaServer;          //porta del server

    protected Socket mySocket;       
    //protected BufferedReader buffer;    //buffer del messaggio
    
    protected String stringaUtente = "";        //messaggio dell'utente
    protected String stringaRicevuta = "null";      //messaggio ricevuto dal server
    
    protected DataOutputStream outVersoServer;  //stream di output
    protected BufferedReader inDalServer;       //stream di input
    

    public Cliente(String ipServer, int portaServer,String stringaUtente){
        this.ipServer.equals(ipServer);
        this.portaServer = portaServer;
        this.stringaUtente = (stringaUtente);
    }

    /**
     * Metodo che stabilisce la connessione al server.
     * Ricerca il server tramite l'indirizzo ip e la porta.
     * @return Ritorna il socket per connettersi al server
     */
    public Socket connetti(){
        System.out.println("2 CLIENT - Partito in esecuzione...");

        try {
            mySocket = new Socket(ipServer, portaServer); //creazione socket da parte del client per connettersi al server
            
            outVersoServer = new DataOutputStream(mySocket.getOutputStream());                  //associamento al socket per effettuare la scrittura(invio)
            inDalServer = new BufferedReader(new InputStreamReader(mySocket.getInputStream())); //associamento al socket per effettuare la lettura(ricezione)
            
        } catch (UnknownHostException uhe) { System.out.println("Host sconosciuto");
        } catch (Exception e) {System.out.println("CLIENT - Errore durante la connessione");}

        return mySocket;
    }

    /**
     * Metodo che comunica col server.
     * Invia il messaggio e lo riceve, successivamente chiude la connessione.
     */
    public void comunica(){
        try {

            System.out.print("\n4 & 5 CLIENT - Invio del messaggio: " + stringaUtente);
            outVersoServer.writeBytes(stringaUtente + "\n");//viene inviato il messaggio al server,\n dice che è finito il messaggio

            stringaRicevuta = inDalServer.readLine();//viene copiato in stringaRicevuta la stringa che ha inviato il server

            System.out.println("\n8 CLIENT - Risposta del server : " + stringaRicevuta);
            System.out.println("9 CLIENT - Finita comunicazione, chiusura connessione");

            mySocket.close(); //chiusura della connessione col server
            
        } catch (Exception e) {System.out.println("\nErrore durante la comunicazione del server");}
    }

}
