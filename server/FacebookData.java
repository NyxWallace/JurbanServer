package server;

public class FacebookData implements IData {
	private static final long serialVersionUID = 1L;
	
	public String Nome, Cognome, Indirizzo, Et�, Genere, Nr_amici, Ultimo_post;
	
	public FacebookData(String nome, String cognome, String indirizzo, String et�, String genere, String nr_amici, String ultimo_post) {
		Nome = nome; Cognome = cognome; Indirizzo = indirizzo; Et� = et�; Genere = genere; Nr_amici = nr_amici; Ultimo_post = ultimo_post;
	}
}
