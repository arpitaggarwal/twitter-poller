package com.test.service;

import java.io.IOException;
import java.util.List;

import twitter4j.TwitterException;

/**
 * <code>ITwitterService</code>
 */
public interface ITwitterService<T> {
	/**
	 * Get tweets from a twitter after every hour.
	 * 
	 */
	void getTweets() throws TwitterException, IOException;

	/**
	 * Query tweets from a database.
	 * 
	 */
	List<T> queryTweets(final String query);
}
