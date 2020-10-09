package com.trip.dao;

import com.trip.domain.Traffic;
import com.trip.domain.TrafficExample;
import java.util.List;

public interface TrafficDao {
    int deleteByPrimaryKey(Integer tpTid);

    int insert(Traffic record);

    int insertSelective(Traffic record);

    List<Traffic> selectByExample(TrafficExample example);

    Traffic selectByPrimaryKey(Integer tpTid);

    int updateByPrimaryKeySelective(Traffic record);

    int updateByPrimaryKey(Traffic record);

	List<Traffic> trafficPointSearch(Traffic traffic);
}