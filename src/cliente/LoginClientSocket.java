package cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JOptionPane;

public class LoginClientSocket {
    
    public static void main(String[] args) throws IOException {
        try {

            // create SSLSocket from factory
            SSLSocketFactory factoria = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factoria.createSocket("127.0.0.1", 10000);

            // create PrintWriter for sending login to server
            PrintWriter output = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()));
            // create BufferedReader for reading server response
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            String userName = JOptionPane.showInputDialog(null,"Introduzca su mensaje:" );

            // Envío del mensaje al servidor
            output.flush();

            // Lee la respuesta del servidor
            String respuesta = input.readLine();

            // Muestra la respuesta al cliente
            JOptionPane.showMessageDialog( null, respuesta);

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