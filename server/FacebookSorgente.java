package server;

//http://restfb.com/#running-examples
//http://restfb.com/javadoc/index.html
//https://developers.facebook.com/ 

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;

public class FacebookSorgente extends Sorgente {

	FacebookData data = new FacebookData();
	
	@Override
	void FillData(final String name) {
		AccessToken accessToken =  new DefaultFacebookClient("CAABbeDUDTL4BAA9ZCg6I3t4fzKoZCDDve1M7mnOYqOifwxoZANyyBpcjqSq0wD1XzVp7ZCJDFB73N4EKH6JX2WihCQan2cnwI3DeIu6g1LNsxWtiQyTaCm92b3AvhWgBDeZCwtHFPh71hXewx0YdYHy5ZCGjzaMhD5iQ4R420TcPoVeuyxUWeLsBbM5iNqoMJFxFeCCIwazgxZBjnmyei4b", com.restfb.Version.VERSION_2_3).obtainExtendedAccessToken("100571843611838", "e6549f56027f674f32b9468786e224ed");
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), com.restfb.Version.VERSION_2_3);
		User me = facebookClient.fetchObject("me", User.class);
		data.Nome = me.getFirstName();
		data.Cognome = me.getLastName();
		data.Indirizzo = me.getHometownName();
		data.Et� = me.getBirthday();
		
	}

	@Override
	FacebookData GetData() {
		return data;
	}

}
