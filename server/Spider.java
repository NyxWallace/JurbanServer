package server;

public class Spider {
	public static void main(String args[])
	{
		//Creo il server e lo faccio girare all'infinito
		SpiderServer server = new SpiderServer();
		while(true){
			server.run();
		}
	}
}
