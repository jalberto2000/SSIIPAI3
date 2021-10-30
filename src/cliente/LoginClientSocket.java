package cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class LoginClientSocket {
    
    public static void main(String[] args) throws IOException {
        try {

            // create SSLSocket from factory
            Socket socket = new Socket("127.0.0.1", 3343);

            // create PrintWriter for sending login to server
            PrintWriter output = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()));

            // create BufferedReader for reading server response
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            boolean b = true;

            // clean up streams and Socket
            output.close();
            input.close();
            socket.close();

        } // end try

        // handle exception communicating with server
        catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // exit application
        finally {
            System.exit(0);
        }

    }
}