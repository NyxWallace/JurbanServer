package server;

public class FacebookData implements IData {
	private static final long serialVersionUID = 1L;
	
	public String Nome, Cognome, Indirizzo, Età, Genere, Nr_amici, Ultimo_post;
	
	public FacebookData(String nome, String cognome, String indirizzo, String età, String genere, String nr_amici, String ultimo_post) {
		Nome = nome; Cognome = cognome; Indirizzo = indirizzo; Età = età; Genere = genere; Nr_amici = nr_amici; Ultimo_post = ultimo_post;
	}
}
