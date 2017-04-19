import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Clase que implementa el cliente.
 */
public class Cliente {
	public static void main(String[] args) {
		try {
			/* Se conecta con el servidor desde el puerto 9999. */
			Socket s = new Socket("localhost", 9999);
			/* Para enviar datos al servidor. */
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			/* Para recibir datos del servidor. */
			BufferedReader bb = new BufferedReader(
				new InputStreamReader(s.getInputStream()));

			String mensaje; // mensaje del servidor
			while((mensaje = bb.readLine()) != null)
				System.out.println(mensaje);
		} catch (UnknownHostException e) {
			System.err.println("No se encontró el host");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Erro en la conexión");
			System.exit(1);
		}
	}
}
