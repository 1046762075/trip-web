package com.trip.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface WordsDao {
	void deleteByPrimaryKey(Integer lw_id);
}
