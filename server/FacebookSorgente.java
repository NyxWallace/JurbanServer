package server;

//http://restfb.com/#running-examples
//http://restfb.com/javadoc/index.html
//https://developers.facebook.com/ 

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class FacebookSorgente extends Sorgente {

	FacebookData data = new FacebookData();
	
	@Override
	void FillData(final String name) {
		FacebookClient facebookClient = new DefaultFacebookClient("CAABbeDUDTL4BAIMdTk27ySy5YanqwXgSjXnZA89SuUn2ElZAPAsn3Fb4o1f0KbOkoTk42LDZBQATJHrILuYINDJZCdaRn5zxYJMBEFiL25EQyDkq2siq1LmzAgj5NVSC2hC7tRCBpwvifqi1O487MoLUOrImfB6vq7AwpZA5VSEYONBbPg6MfhXIkgJhu7PtDFMFZAcZCa7HLEYkUwehtzk", "e6549f56027f674f32b9468786e224ed", com.restfb.Version.VERSION_2_3);
		User me = facebookClient.fetchObject("me", User.class);
		data.Nome = me.getFirstName();
		data.Cognome = me.getLastName();
		data.Indirizzo = me.getHometownName();
		data.Età = me.getBirthday();
	}

	@Override
	FacebookData GetData() {
		return data;
	}

}
