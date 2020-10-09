package com.trip.service;

import com.trip.domain.Forum;

import java.util.List;

public interface ForumService {
	/**
	 * 	查询所有帖子
	 */
	List<Forum> selectByExampleWithBLOBs();
}
