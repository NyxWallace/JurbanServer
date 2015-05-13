package server;
import com.restfb.*;
import com.restfb.types.*;
public class Test {
	public static void main(String[] args) {
		FacebookClient facebookClient = new DefaultFacebookClient("CAABbeDUDTL4BACit1cKz0THNfz6YCZB15xZB0AMUZCaIZCAxr1vQCO3WmN9SDiuZARBvaJTjFq2lZCXXmiNC1Ksu5jAm5OQqdGRWBhW6MALtqMe96K6JFH2ykGFZBbynEpiUXK3VceTiwGsLSagqFjtQDIe292AbkRLkGoX3IXW1O52XN3QcVcx9AWJiIXw1I04cHmzJ08AxZAqXWFJ3pRXD", "e6549f56027f674f32b9468786e224ed", com.restfb.Version.VERSION_2_3);
		User user = facebookClient.fetchObject("me", User.class);
		System.out.println(user.getFirstName());
		Connection<Post> publicSearch = facebookClient.fetchConnection("search", Post.class, Parameter.with("q", "Antoine Farine"), Parameter.with("type", "user"));
		User nuno = facebookClient.fetchObject(publicSearch.getData().get(2).getId(), User.class);
		int i = 1;
		for(Post p : publicSearch.getData()){
			System.out.println(i + " " + p.getName());
			++i;
		}
		System.out.println(nuno.getBirthday());
	}
}
