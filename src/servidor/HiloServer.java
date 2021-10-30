package servidor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class HiloServer implements Runnable{
    SSLServerSocket serverSocket;
    SSLServerSocketFactory socketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
    public HiloServer() throws IOException { }


    @Override
    public void run() {
        //while(true){
            try{
                System.err.println("Waiting for connection...");

                serverSocket = (SSLServerSocket) socketFactory.createServerSocket(10000);
                Socket socket = serverSocket.accept();

                LoginServerSocket.logicaServidor(socket);

            }
            catch (IOException e){
                e.printStackTrace();

            }
        //}

    }

    public static void main(String[] args) throws IOException {
        HiloServer hilo = new HiloServer();
        Thread thread = new Thread(hilo);
        thread.start();

    }
}
