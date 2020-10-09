package com.trip.controller;

import com.trip.dao.TrafficDao;
import com.trip.domain.Traffic;
import com.trip.domain.TrafficExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "traffic")
public class TrafficController {
	@Autowired
	TrafficDao trafficDao;

	/**
	 *
	 * @param currentCity
	 * @param desCity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectByCurrentAndDestination", method = RequestMethod.GET)
	public List<Traffic> traffic(String currentCity, String desCity) {
		TrafficExample example = new TrafficExample();
		List<Traffic> traffics = trafficDao.selectByExample(example);

		List<Traffic> queryTraffics = new ArrayList<>();

		for(Traffic traffic : traffics){
			if (currentCity.equals(traffic.getTpCurrent()) && desCity.equals(traffic.getTpDestination())){
				queryTraffics.add(traffic);
			}
		}
		return queryTraffics;
	}
}
