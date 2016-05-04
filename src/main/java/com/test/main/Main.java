package com.test.main;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import twitter4j.TwitterException;

import com.test.service.impl.TwitterService;

/**
 * Class <code>Main</code> is the invoking point of an application.
 * 
 * @author ArpitAggarwal
 *
 */
public class Main {

	final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		String searchTerm = getSearchTermAsInput();
		if (StringUtils.isBlank(searchTerm)) {
			searchTerm = "Arpit";
		}
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-dispatcher.xml");
		poll(searchTerm, context);
	}

	private static String getSearchTermAsInput() {
		System.out.println("Enter Search Term :: ");
		try (Scanner scanner = new Scanner(System.in)) {
			return scanner.next();
		}
	}

	private static void poll(final String searchTerm,
			final AbstractApplicationContext context) {
		final TwitterService twitterService = (TwitterService) context
				.getBean("twitterService");
		try {
			twitterService.setSearchTerm(searchTerm);
			twitterService.getTweets();
		} catch (TwitterException | IOException e) {
			LOGGER.error("exception occurred while reading tweets", e);
		}
	}
}
