package it.fi.meucci;

/**
 * Questa classe serve per poter creare dei più clienti che contemporaneamente contatteranno il server multi-thread per richiedere un servizio.
 * @author Dardan Matias Berisha
 */
public class ClientThread extends Thread{

    protected Cliente client;
    
    public ClientThread(Cliente c) {
        client = c;
    }

    @Override
    public void run() {
        client.connetti();
        client.comunica();
    }
    
    
    
}
