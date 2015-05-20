package server;

//http://restfb.com/#running-examples
//http://restfb.com/javadoc/index.html
//https://developers.facebook.com/

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class FacebookData extends Sorgente {

	@Override
	void FillData(final String name) {
		//FacebookClient facebookClient = new DefaultFacebookClient("100571843611838|sz_tn55UkJZntReF49fDUTS4MdA", "e6549f56027f674f32b9468786e224ed", com.restfb.Version.VERSION_2_3);
		System.out.println("Filling FB results for " + name);
	}

	@Override
	String GetData() {
		return null;
	}

}
