import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("EL SERVIDOR HA INICIADO");
        // Intentaremos conectar al servidor
        try (ServerSocket socketServidor = new ServerSocket(5001);) {
            // Se acepta la conexión del cliente
            Socket socketCliente = socketServidor.accept();
            System.out.println("Se ha establecido la conexión con el cliente");
            // EL buffer de lectura servirá para obtener la cadena del cliente
            BufferedReader bufferLectura = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
            String line;
            // A través del buffer de lectura se obtiene la información que luego será
            // enviada de regreso
            while ((line = bufferLectura.readLine()) != null) {
                System.out.println("Mensaje recibido: " + line);
                salida.println(line);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
