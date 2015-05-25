package server;

//http://zerioh.tripod.com/ressources/sockets.html			Sito di esempi su come implementare il socket

import java.io.*;
import java.net.*;
import java.util.*;

public class SpiderServer{
	private ServerSocket socket;
	private Socket connection = null;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String nome, cognome;
	private List<Sorgente> socials = new ArrayList<Sorgente>();
	
	void run()
	{
		try{
			//Creo il socket sulla porta 2004
			socket = new ServerSocket(2004);
			//Resto in attesa della connessione
			System.out.println("In attesa della connessione");
			connection = socket.accept();
			//Log sulla connessione in entrata
			System.out.println("Connessione ricevuta da " + connection.getInetAddress().getHostName());
			//Creo gli stream per la comunicazione tra client e server
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
			send_message("Connessione riuscita");
			try{
				//Mi faccio passare il nome dal client per effettuare la ricerca
				nome = (String)in.readObject();
				cognome = (String)in.readObject();
				search_and_send();
				//Messaggio che segnala al client che la transazione è terminata
				send_message("bye");
			}
			catch(ClassNotFoundException classnot){
				System.err.println("Data received in unknown format");
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			try{
				//Chiudi gli steam e la connessione con il client
				in.close();
				out.close();
				socket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	
	private void search_and_send(){
		//Per ogni sorgente disponibile faccio partire la ricerca dei dati e mi faccio tornare le informazioni
		for(Sorgente s : socials){
			s.FillData(nome + " " + cognome);
			send_message(s.GetData());
		}
	}
	
	private void send_message(Object msg)
	//Metodo per inviare dati sulla connessione
	{
		try{
			out.writeObject(msg);
			out.flush();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	public SpiderServer() {
		//Aggiungo le varie sorgenti supportate
		socials.add(new FacebookSorgente());
		socials.add(new TwitterSorgente());
	}
}