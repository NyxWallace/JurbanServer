package server;

public class Spider {
	
	public static String FB_accessToken = "CAABbeDUDTL4BAFaIQXGrSduDvECugNTCM4cFXaYQzoeVZBKSgIAebaylcumFpuCWfgKBBHFgxgB02pUf0vvZBEOyeh1qZB71qeTjC54hVXFCDuU63WvDe9tJnBVXlQOHaYVKS6EJI5ZAeZA682q8vnd1wLSe6wGE7jZAg49i6Lm5aYqX4G90CQhsOzB0V53GfQeskWG59j7QHlf8acxBhX";
	
	public static void main(String args[])
	{
		//Creo il server e lo faccio girare all'infinito
		SpiderServer server = new SpiderServer();
		while(true){
			server.run();
		}
	}
}
