package br.com.dayhan.tests.twitter;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.dayhan.factory.TwitterBuilder;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class MyTweetsTest {

	@Test
	public void test() throws TwitterException {
		TwitterBuilder builder = new TwitterBuilder();
		Twitter twitter = builder.getTwitter();
		List<Status> timeline = twitter.getHomeTimeline();
	    System.out.println("\n===================== Últimos tweets ========================\n");
	    assertNotNull(timeline);
	    for (Status status : timeline) {
	        System.out.println(status.getUser().getName() + ": " +
	                           status.getText());
	        System.out.println("-------------------------------------------------------------------");
	    }
	}

}
