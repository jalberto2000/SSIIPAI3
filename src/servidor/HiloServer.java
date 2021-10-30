package servidor;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloServer implements Runnable{

    SSLServerSocketFactory factoria = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
    ServerSocket serverSocket = (SSLServerSocket) factoria.createServerSocket(10000);



    public HiloServer() throws IOException { }


    @Override
    public void run() {
        while(true){
            try{
                System.err.println("Waiting for connection...");
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                LoginServerSocket.logicaServidor(socket);
            }
            catch (IOException e){
                e.printStackTrace();

            }
        }

    }

    public static void main(String[] args) throws IOException {
        HiloServer hilo = new HiloServer();
        Thread thread = new Thread(hilo);
        thread.start();

    }
}
