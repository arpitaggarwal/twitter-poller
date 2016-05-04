package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.domain.Tweets;

/**
 * Class <code>TweetsDao</code> is the implementation of
 * com.test.dao.BaseDao to persist {@link Tweets}
 * 
 * @author ArpitAggarwal
 *
 */
@Repository
public class TweetsDao extends BaseDao<Tweets> {

	@Override
	protected Class<Tweets> getEntityClass() {
		return Tweets.class;
	}

}
