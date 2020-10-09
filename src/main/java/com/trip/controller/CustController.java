package com.trip.controller;

import com.trip.dao.HotelDao;
import com.trip.dao.TrafficDao;
import com.trip.dao.ViewPointDao;
import com.trip.domain.ViewPointExample;
import com.trip.domain.Hotel;
import com.trip.domain.HotelExample;
import com.trip.domain.ViewPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "cust")
public class CustController {
	@Autowired
	TrafficDao trafficDao;
	@Autowired
	ViewPointDao viewPointDao;
	@Autowired
	HotelDao hotelDao;
	/**
	 * 跳转定制
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "proscenium/cust/index";
	}

	/**
	 * 定制返回景
	 */
	@ResponseBody
	@RequestMapping(value = "viewPoint", method = RequestMethod.GET)
	public List<ViewPoint> viewPoint(String tpLocation) {
		ViewPointExample example = new ViewPointExample();
		example.createCriteria().andTpLocationEqualTo(tpLocation);
		example.setOrderByClause("tp_vid desc");
		List<ViewPoint> viewPoints = viewPointDao.selectByExample(example);
		return viewPoints;
	}

	/**
	 * 定制返回酒店
	 */
	@ResponseBody
	@RequestMapping(value = "hotel", method = RequestMethod.GET)
	public List<Hotel> hotel(String local) {
		HotelExample example = new HotelExample();
		example.createCriteria().andLocalEqualTo(local);
		example.setOrderByClause("hid desc");
		System.out.println(example);
		List<Hotel> hotels = hotelDao.selectByExample(example);
		System.out.println(hotels);
		return hotels;
	}
}
