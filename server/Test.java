package server;
import com.restfb.*;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.*;
public class Test {
	public static void main(String[] args) {
		AccessToken accessToken =  new DefaultFacebookClient("CAABbeDUDTL4BAA9ZCg6I3t4fzKoZCDDve1M7mnOYqOifwxoZANyyBpcjqSq0wD1XzVp7ZCJDFB73N4EKH6JX2WihCQan2cnwI3DeIu6g1LNsxWtiQyTaCm92b3AvhWgBDeZCwtHFPh71hXewx0YdYHy5ZCGjzaMhD5iQ4R420TcPoVeuyxUWeLsBbM5iNqoMJFxFeCCIwazgxZBjnmyei4b", com.restfb.Version.VERSION_2_3).obtainExtendedAccessToken("100571843611838", "e6549f56027f674f32b9468786e224ed");
		System.out.println(accessToken.getExpires());
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), com.restfb.Version.VERSION_2_3);
		User me = facebookClient.fetchObject("me", User.class);
		System.out.println(me.getFirstName() + "-" + me.getLastName() + "-" + me.getAbout() + "-" + me.getBio() + "-" + me.getBirthday() + "-" + me.getEmail() + "-" + me.getGender());
		Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
		Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);
		System.out.println(myFriends.getData().size());
		if(myFeed.getData().size() > 0)
			System.out.println(myFeed.getData().get(0));
		else
			System.out.println("No post avaiable");
	}
}
