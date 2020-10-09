package com.trip.controller;

import com.trip.dao.HotelDao;
import com.trip.domain.ViewPointExample;
import com.trip.service.ViewPointService;
import com.trip.domain.Hotel;
import com.trip.domain.HotelExample;
import com.trip.domain.ViewPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "")
public class IndexController {

	@Autowired
	private ViewPointService viewPointService;
	@Autowired
	private HotelDao hotelDao;

	/**
	 * 跳转首页
	 */
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ViewPointExample example, Model model) {
		HotelExample hotelExample = new HotelExample();
		example.setOrderByClause("tp_vid desc");
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);

		//酒店
		hotelExample.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(hotelExample);

		//传送景点
		model.addAttribute("viewPoints", viewPoints);
		model.addAttribute("hotels", hotels);
		return "index";
	}

}
