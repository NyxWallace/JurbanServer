package server;

//http://restfb.com/#running-examples				Pacchetto di librerie open source per lavorare con le API di FB
//http://restfb.com/javadoc/index.html
//https://developers.facebook.com/ 					Necessario per registrare l'applicazione e ottenere il token, l'ID e il segreto

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FacebookSorgente extends Sorgente {
	//Creo il client FB con cui in seguito lavorerò usando il token, l'ID e il secret dell'app
	private FacebookClient facebookClient = new DefaultFacebookClient(Spider.FB_accessToken, "e6549f56027f674f32b9468786e224ed", com.restfb.Version.VERSION_2_3);
	
	@Override
	public void FillData(final String name) {
		//Provo a recuperare dati dal mio profilo
		User me = facebookClient.fetchObject("me", User.class);
		//A causa della difficoltà di reperire le informazioni pesonali abbiamo usato me come utente, il metodo seguente ritorna altri utenti in base al nome
		//User user = search_user(name);
		Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
		Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);
		String nr_amici = ""+myFriends.getData().size();
		String ultimo_post;
		if(myFeed.getData().size() > 0)
			ultimo_post = myFeed.getData().get(0).getMessage();
		else
			ultimo_post = "I post di questo utente non sono disponibili";
		//Creo il contenitore dati da inviare al client
		dati = new FacebookData(me.getFirstName(), 
								me.getLastName(), 
								me.getHometownName(), 
								me.getBirthday(), 
								me.getGender(), 
								nr_amici, 
								ultimo_post);
	}

	@Override
	public IData GetData() {
		return dati;
	}
	
	@SuppressWarnings("unused")
	private User search_user(String name){
		Connection<User> publicSearch = facebookClient.fetchConnection("search", User.class, Parameter.with("q", name), Parameter.with("type", "user"));
		if(publicSearch.getData().size() > 0)
			return publicSearch.getData().get(0);
		return null;
	}

}
