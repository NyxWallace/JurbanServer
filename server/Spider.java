package server;

public class Spider {
	
	public static String FB_accessToken = "CAABbeDUDTL4BANZCKLj8i6RrRPsAhccpdbbVyWVJZAbAzsw8E7ZBXp52BWrRQkFqYbizOXOWCQ3eCMNCd1FJYMArnfMTNMyYK47HJl3Aftxpu4i9XhXTOBa7MLQMLvfrXBIb4yV24oUlDmDA6GUWmdqdHhtC7mtWRqFjcco9SD3ZADdXr4Sssemo20etg9fwfnvtow0knKG5OkI9jldT";
	
	public static void main(String args[])
	{
		//Creo il server e lo faccio girare all'infinito
		SpiderServer server = new SpiderServer();
		while(true){
			server.run();
		}
	}
}
