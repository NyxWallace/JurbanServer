package server;

//http://restfb.com/#running-examples				Pacchetto di librerie open source per lavorare con le API di FB
//http://restfb.com/javadoc/index.html
//https://developers.facebook.com/ 					Necessario per registrare l'applicazione e ottenere il token, l'ID e il segreto

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FacebookSorgente extends Sorgente {

	FacebookData data;
	
	@Override
	void FillData(final String name) {
		//Ritorna un Token con data di scadenza estesa utilizzando l'attuale token, l'ID e il segreto dell'applicazione
		AccessToken accessToken =  new DefaultFacebookClient("CAABbeDUDTL4BAA9ZCg6I3t4fzKoZCDDve1M7mnOYqOifwxoZANyyBpcjqSq0wD1XzVp7ZCJDFB73N4EKH6JX2WihCQan2cnwI3DeIu6g1LNsxWtiQyTaCm92b3AvhWgBDeZCwtHFPh71hXewx0YdYHy5ZCGjzaMhD5iQ4R420TcPoVeuyxUWeLsBbM5iNqoMJFxFeCCIwazgxZBjnmyei4b", com.restfb.Version.VERSION_2_3)
															.obtainExtendedAccessToken("100571843611838", "e6549f56027f674f32b9468786e224ed");
		//Creo il client FB con cui in seguito lavorerò usando il token
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), com.restfb.Version.VERSION_2_3);
		//Provo a recuperare dati dal mio profilo
		User me = facebookClient.fetchObject("me", User.class);
		Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
		Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);
		String nr_amici = ""+myFriends.getData().size();
		String ultimo_post;
		if(myFeed.getData().size() > 0)
			ultimo_post = myFeed.getData().get(0).getMessage();
		else
			ultimo_post = "I post di questo utente non sono disponibili";
		//Creo il contenitore dati da inviare al client
		data = new FacebookData(me.getFirstName(), 
								me.getLastName(), 
								me.getHometownName(), 
								me.getBirthday(), 
								me.getGender(), 
								nr_amici, 
								ultimo_post);
	}

	@Override
	FacebookData GetData() {
		return data;
	}

}
