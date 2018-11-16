package snmpjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClientSocket {

	public static void main(String args[]) throws IOException {
		final String host = "localhost";
		boolean status = true;
		final int portNumber = 8080;
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);

		while (status==true) {
			Socket socket = new Socket(host, portNumber);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("Server: " + br.readLine());

			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
			String userInput = userInputBR.readLine();

			out.println(userInput);
			
			if("1".equals(userInput))
            {
			BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//StringBuilder everything = new StringBuilder();
			
				while (br2.readLine() != null)
				{
					//everything.append(br2);
					System.out.println("Server: " + br2.readLine());
				
				}
            }
			
			else if("2".equals(userInput))
            {
                 socket.close();
                 System.out.println("Closing connetion.....");
                 status=false;
            }
						
		}


	}
}