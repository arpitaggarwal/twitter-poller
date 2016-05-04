package com.test.service.impl;

import static com.test.constants.ApplicationConstants.DATA_FILE;
import static com.test.constants.ApplicationConstants.LANGAUGE;
import static com.test.constants.ApplicationConstants.ONE_MINUTE_IN_MILLIS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import com.test.config.OAuthServiceConfigurationProvider;
import com.test.service.ITwitterService;

@Service
public class TwitterService implements ITwitterService<Status> {

	final static Logger LOGGER = LoggerFactory.getLogger(TwitterService.class);

	private static Query query = new Query();

	private String searchTerm;

	@Autowired
	private OAuthServiceConfigurationProvider configurationBuilder;

	@Scheduled(fixedRate = 60 * ONE_MINUTE_IN_MILLIS)
	public void getTweets() throws TwitterException, IOException {

		Twitter twitter = getTwitterInstance();
		buildQueryString();
		QueryResult result = twitter.search(query);

		LOGGER.info("Number of Tweets are : " + result.getTweets().size());

		while (result.getTweets().size() != 0) {
			List<Status> tweets = result.getTweets();
			Long minId = Long.MAX_VALUE;
			for (Status tweet : tweets) {
				writeToStore(tweet);
				if (tweet.getId() < minId)
					minId = tweet.getId();
			}
			query.setMaxId(minId - 1);
			result = twitter.search(query);
		}
	}

	/**
	 * Writes tweet data to a file.
	 * 
	 * @param tweet
	 * @throws IOException
	 */
	private void writeToStore(final Status tweet) throws IOException {
		File file = new File(DATA_FILE);
		if (!file.exists()) {
			file.createNewFile();
		}
		if (tweet != null) {
			Files.write(Paths.get(DATA_FILE), tweet.toString().getBytes(),
					StandardOpenOption.APPEND);
		}

	}

	private void buildQueryString() {
		query.setQuery("from:" + getSearchTerm());
		query.setLang(LANGAUGE);
	}

	public List<Status> queryTweets(final String query) {
		return null;
	}

	/**
	 * Returns a instance associated with the configuration bound to
	 * {@link TwitterFactory}.
	 *
	 * @return default singleton instance
	 */
	private Twitter getTwitterInstance() {
		Twitter twitter = new TwitterFactory(
				configurationBuilder.getConfiguration()).getInstance();
		return twitter;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(final String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
