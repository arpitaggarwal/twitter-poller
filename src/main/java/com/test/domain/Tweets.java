package com.test.domain;

import java.util.Date;

public class Tweets {

	private final long id;
	private final String text;
	private final String source;
	private final Date createdAt;
	private final boolean isRetweeted;
	private final boolean isTruncated;
	private final int favoriteCount;

	public Tweets(final long id, final String text, final String source,
			final Date createdAt, final boolean isRetweeted,
			final boolean isTruncated, final int favoriteCount) {
		this.id = id;
		this.text = text;
		this.source = source;
		this.createdAt = new Date(createdAt.getTime());
		this.isRetweeted = isRetweeted;
		this.isTruncated = isTruncated;
		this.favoriteCount = favoriteCount;
	}

	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getSource() {
		return source;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public boolean isRetweeted() {
		return isRetweeted;
	}

	public boolean isTruncated() {
		return isTruncated;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}
}
