package br.com.dayhan.factory;

import br.com.dayhan.api.Api;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterBuilder implements Api{
	
	private Twitter twitter;
	
	public Twitter getTwitter() {
		return twitter;
	}

	public TwitterBuilder() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("h3Oc4dvSuw32SQ7N8oKpoAr94")
		  .setOAuthConsumerSecret("dMwQyfrrYGI08eMxKixkXwOGoQ0pi1kB5VjOwpLoLZvvlBnI0h")
		  .setOAuthAccessToken("729856469877821440-L9Y6vutGzdeR71uqp7UaYLc43QpWHkj")
		  .setOAuthAccessTokenSecret("cNZHmrhBvoF4CnpVN1Q3eDPsDUHvycKrb3HfF2mN1eiMc");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}

	@Override
	public void printSearch(String search) {
		Query query = new Query(search);
	    QueryResult result;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			throw new RuntimeException("Não foi possível consultar a API do Twitter");
		}
		if(!result.getTweets().isEmpty()) {
			for (Status status : result.getTweets()) {
				System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
				System.out.println("-------------------------------------------------------------------");
			}
		} else {
			System.out.println("Sorry, not there is tweets about this project");
		}
	}
}
