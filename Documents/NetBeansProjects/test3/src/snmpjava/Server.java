package snmpjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    public static void main(String args[]) throws IOException 
	{
		final int portNumber = 8080;
		System.out.println("Creating server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
                boolean status=true;        
               
               while(status==true) 
		{ 
                        Socket socket = serverSocket.accept();
                        if(socket.isConnected()==true)
                        {
                        
                        OutputStream os = socket.getOutputStream();
                        PrintWriter pw = new PrintWriter(os, true);
			pw.println("Please select: (1) Hardware Details, (2) Exit and Closed Connection");
			
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();
                        
                        
                        if ("1".equals(str))
                        {
                                pw.println("OS Name : " + System.getProperty("os.name"));
				pw.println("Version : " + System.getProperty("os.version"));
				pw.println("Arch : " + System.getProperty("os.arch"));
				pw.println("Number of Available processors (cores): " + Runtime.getRuntime().availableProcessors());
				pw.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());
				pw.println("Max memory (bytes): " + Runtime.getRuntime().maxMemory());
					
				pw.close();
                                br.close();
                                status=true;
                        }
                        else if("2".equals(str))
                        {
                            
                                socket.close();
                                pw.close();
                                br.close();
                                status=false;
                        }
                        
                        }
                        
                        
		}
	}
    
}
