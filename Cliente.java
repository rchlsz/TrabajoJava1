import java.io.*;
import java.net.*;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente{
    public static void main(String[] args) {
        
        System.out.println("El cliente ha iniciado");
        
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            Socket socketCliente = new Socket(localHost, 5001);
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
            BufferedReader bufferDeLectura = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            System.out.println("Se ha establecido conexion al servidor");
            Scanner lectura = new Scanner(System.in);

            while(true){
                System.out.println("Ingrese una cadena: ");
                String entrada = lectura.nextLine();
                if("".equalsIgnoreCase(entrada)){
                    break;
                }

                salida.println(entrada);
                String response = bufferDeLectura.readLine();
                System.out.println("Respuesta del servidor: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}