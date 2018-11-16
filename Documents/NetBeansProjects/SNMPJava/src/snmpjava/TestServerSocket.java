package snmpjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerSocket
{

	public static void main(String args[]) throws IOException 
	{
		final int portNumber = 8080;
		System.out.println("Creating server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		while (true) 
		{
			Socket socket = serverSocket.accept();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			pw.println("Please select: (1) Hardware Details, (2) Exit");

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();					

			switch(str) 
			{
			case "1": 
				
				pw.println();
				pw.println("OS Name : " + System.getProperty("os.name"));
				pw.println();
				pw.println("Version : " + System.getProperty("os.version"));
				pw.println();
				pw.println("Arch : " + System.getProperty("os.arch"));
				pw.println();
				pw.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());
				pw.println();
				pw.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());
				pw.println();
				pw.println("Maximum memory (bytes): " + Runtime.getRuntime().maxMemory());
				pw.println();
				pw.println("Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory());

				pw.close();
				socket.close();		

				br.close();

				break;

			case "2":

				pw.println("Closing connection..."); 
				// close connection 
				 socket.close();
                 pw.close();
                 br.close();
                 
				break;
			}
		}
	}
}