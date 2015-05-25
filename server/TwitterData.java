package server;

public class TwitterData implements IData {
	private static final long serialVersionUID = 1L;
	
	public String Nome, Cognome, Ultimo_tweet;
	
	public TwitterData(String nome, String cognome,  String ultimo_tweet) {
		Nome = nome; Cognome = cognome; Ultimo_tweet = ultimo_tweet;
	}
}
