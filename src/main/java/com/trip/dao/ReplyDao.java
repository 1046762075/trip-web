package com.trip.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ReplyDao {
	void deleteByPrimaryKey(Integer lr_id);
}
