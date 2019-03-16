package br.com.dayhan.tests.twitter;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.dayhan.factory.TwitterBuilder;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class SearchTweets {

	@Test
	public void test() throws TwitterException {
		TwitterBuilder builder = new TwitterBuilder();
		Twitter twitter = builder.getTwitter();
		
		Query query = new Query("#internetofthings");
	    QueryResult result = twitter.search(query);
	    assertNotNull(result.getTweets());
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
	        System.out.println("-------------------------------------------------------------------");
	    }
	}

}
