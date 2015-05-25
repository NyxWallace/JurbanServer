package server;

//http://zerioh.tripod.com/ressources/sockets.html

import java.io.*;
import java.net.*;
import java.util.*;

public class SpiderServer{
	private ServerSocket providerSocket;
	private Socket connection = null;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String nome, cognome;
	private List<Sorgente> socials = new ArrayList<Sorgente>();
	
	void run()
	{
		try{
			//1. creating a server socket
			providerSocket = new ServerSocket(2004, 10);
			//2. Wait for connection
			System.out.println("Waiting for connection");
			connection = providerSocket.accept();
			System.out.println("Connection received from " + connection.getInetAddress().getHostName());
			//3. get Input and Output streams
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
			sendMessage("Connection successful");
			//4. The two parts communicate via the input and output streams
			try{
				nome = (String)in.readObject();
				cognome = (String)in.readObject();
				SearchAndSend();
				sendMessage("bye");
			}
			catch(ClassNotFoundException classnot){
				System.err.println("Data received in unknown format");
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				providerSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	
	private void SearchAndSend(){
		for(Sorgente s : socials){
			s.FillData(nome + " " + cognome);
			sendMessage(s.GetData());
		}
	}
	
	void sendMessage(Object msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			//System.out.println("server>" + msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	public SpiderServer() {
		socials.add(new FacebookSorgente());
	}
}