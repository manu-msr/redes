import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHilo extends Thread {
	
	/* Enchufe (socket) que tendrá cada hilo. */
	private Socket socket = null;

	/**
	 * Constructor a partir de un parámetro.
	 * Construye el Hilo a partir del enchufe que es pasado como parámetro.
	 * @param socket - Enchufe desde el cual crear el hilo.
	 */
	public ServidorHilo(Socket socket) {
		super("ServidorHilo");
		this.socket = socket;;
	}

	/* Código que ejecutará cada hilo. */
	public void run() {
		try {
			/* Para enviar datos al cliente. */
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			/* Para recibir datos del cliente. */
			BufferedReader bb = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));

			// Aquí se inicia la comunización con el cliente.
			while(true)
				pw.println("Cliente conectado");
			//socket.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
