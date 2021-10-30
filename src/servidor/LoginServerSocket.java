package servidor;

import javax.net.ssl.SSLServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;


public class LoginServerSocket {

    public static void logicaServidor(Socket socket) throws IOException {
        try {

            // open BufferedReader for reading data from client
            BufferedReader input = new BufferedReader(new
                    InputStreamReader(socket.getInputStream()));

            // open PrintWriter for writing data to client
            PrintWriter output = new PrintWriter(new
                    OutputStreamWriter(socket.getOutputStream()));
            boolean b = true;
            while(b){
                input.readLine();
            }
            output.close();
            input.close();
            socket.close();

        } // end try

        // handle exception communicating with client
        catch (IOException ioException) {
            ioException.printStackTrace();
        }

    } // end





}

