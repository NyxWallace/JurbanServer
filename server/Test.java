package server;

//Classe creata al solo scopo di effettuare dei test

import com.restfb.*;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.*;
public class Test {
	public static void main(String[] args) {
		AccessToken accessToken =  new DefaultFacebookClient("CAABbeDUDTL4BAAGjqZBZAqdgDK7gbHETRuSJbJJdeGN4Qdce3i6y9UolF2ZCs6EQKV1I7SU5FNKwyA2b5gbbOWqVGLaNOKg208jIDaboIxj78iOcIqxSdHST8OIT4GMAthTtsipC1uJUtz3m2HN2J9ZB6ZBWotyo4EbJVQkjY5tZC7NfXm4vAggDGZB884z8uacANnrZAsuKPDiwFVv8vTZA9", com.restfb.Version.VERSION_2_3).obtainExtendedAccessToken("100571843611838", "e6549f56027f674f32b9468786e224ed");
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
