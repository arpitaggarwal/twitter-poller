package com.test.config;

public final class OAuthServiceConfig {

	private final String apiKey;
	private final String apiSecret;
	private final String accessToken;
	private final String accessTokenSecret;

	public OAuthServiceConfig(final String apiKey, final String apiSecret,
			final String accessToken, final String accessTokenSecret) {
		super();
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.accessToken = accessToken;
		this.accessTokenSecret = accessTokenSecret;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

}
