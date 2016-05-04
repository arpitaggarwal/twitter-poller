package com.test.config;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class OAuthServiceConfigurationProvider {

	private OAuthServiceConfig config;

	public OAuthServiceConfigurationProvider() {
	}

	public OAuthServiceConfigurationProvider(final OAuthServiceConfig config) {
		this.config = config;
	}

	/**
	 * Build {@link Configuration} object to access twitter api
	 * 
	 * @return
	 */
	public Configuration getConfiguration() {
		return new ConfigurationBuilder()
				.setOAuthConsumerKey(config.getApiKey())
				.setOAuthConsumerSecret(config.getApiSecret())
				.setOAuthAccessToken(config.getAccessToken())
				.setOAuthAccessTokenSecret(config.getAccessTokenSecret())
				.build();
	}

}
