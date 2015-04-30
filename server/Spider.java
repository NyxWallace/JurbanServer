package server;

public class Spider {
	public static void main(String args[])
	{
		SpiderServer server = new SpiderServer();
		while(true){
			server.run();
		}
	}
}
