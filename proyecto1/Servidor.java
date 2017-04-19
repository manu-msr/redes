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
			ServerSocket servidor = new ServerSocket(9999);
			while(true)
				new ServidorHilo(servidor.accept()).start();
		} catch (IOException e) {
			System.out.println("Excepción lanzada al tratar de conectar con el" 
				+ "puerto 9999 or escuchando una conexión");
			System.out.println(e.getMessage());
		}	
	}
}
