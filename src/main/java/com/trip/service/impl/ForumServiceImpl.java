package com.trip.service.impl;

import com.trip.dao.ForumDao;
import com.trip.service.ForumService;
import com.trip.domain.Forum;
import com.trip.domain.ForumExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {
	@Autowired
	ForumDao forumDao;

	@Override
	public List<Forum> selectByExampleWithBLOBs() {
		ForumExample example = new ForumExample();
		example.setOrderByClause("tp_fid desc");
		List<Forum> forums = forumDao.selectByExample(example);
		return forums;
	}
}
