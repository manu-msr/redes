import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase que implementa el servidor.
 */
public class Servidor {
	public static void main(String[] args) {
		try {
			/* Creamos un enchufe(socket) que escuche en el puerto 9999. */
			ServerSocket servidor = new ServerSocket(9999);
			/* Aceptamos la conexión de un cliente. */
			Socket cliente = servidor.accept();
			/* Para enviar datos al cliente. */
			PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
			/* Para recibir datos del cliente. */
			BufferedReader bb = new BufferedReader(
				new InputStreamReader(cliente.getInputStream()));

			// Aquí se inicia la comunización con el cliente.
			pw.println("Cliente conectado");
		} catch (IOException e) {
			System.out.println("Excepción lanzada al tratar de conectar con el" 
				+ "puerto 9999 or escuchando una conexión");
			System.out.println(e.getMessage());
		}	
	}
}
