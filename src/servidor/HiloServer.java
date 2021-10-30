package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloServer implements Runnable{
    ServerSocket serverSocket = new ServerSocket(3343);

    public HiloServer() throws IOException { }


    @Override
    public void run() {
        while(true){
            try{
                System.err.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
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
