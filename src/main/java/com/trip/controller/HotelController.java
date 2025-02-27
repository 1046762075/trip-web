package com.trip.controller;

import com.trip.dao.HotelDao;
import com.trip.domain.Words;
import com.trip.commons.Msg;
import com.trip.domain.Hotel;
import com.trip.domain.HotelExample;
import com.trip.domain.Reply;
import com.trip.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "hotel")
public class HotelController {
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private ViewPointService viewPointService;

	/**
	 * 跳转首页
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model) {
		//实例化hotel examle
		HotelExample example = new HotelExample();
		example.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(example);
		//传送景点
		model.addAttribute("hotels", hotels);
		return "proscenium/hotel/index";
	}

	/**
	 * 跳转首页
	 */
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String content(Integer hid, Model model) {

		//封装留言信息
		List<Words> lw_list = viewPointService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		List<Reply> lr_list = viewPointService.findByReply();
		model.addAttribute("lr_list",lr_list);

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);
		model.addAttribute("hotel", hotel);

		return "proscenium/hotel/content";
	}

	/**
	 * 钱台酒店模糊搜索
	 */
	@RequestMapping(value = "hotelPointSearch", method = RequestMethod.GET)
	public String hotelPointSearch(String keyword, Model model) {
		Hotel hotel = new Hotel();

		hotel.setLocal(keyword);
		hotel.setHouseType(keyword);
		hotel.setBedType(keyword);

		List<Hotel> hotels = hotelDao.hotelPointSearch(hotel);

		model.addAttribute("hotels", hotels);
		model.addAttribute("msg", Msg.success("酒店查询成功!"));

		return "proscenium/hotel/index";
	}
}
