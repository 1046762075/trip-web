package com.trip.controller;

import com.trip.dao.ViewPointDao;
import com.trip.domain.ViewPointExample;
import com.trip.domain.Words;
import com.trip.commons.Msg;
import com.trip.domain.Reply;
import com.trip.domain.ViewPoint;
import com.trip.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "view")
public class ViewPointController {
	@Autowired
	private ViewPointService viewPointService;

	@Autowired
	private ViewPointDao viewPointDao;

	/**
	 * 旅游景点跳转
	 * @return
	 */
	@RequestMapping(value = "point", method = RequestMethod.GET)
	public String viewPoint(ViewPointExample example, Model model) {
		example.setOrderByClause("tp_vid desc");

		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		model.addAttribute("viewPoints", viewPoints);
		return "proscenium/viewpoint/view";
	}

	/**
	 * 前台景点模糊搜索
	 *
	 * 待完成
	 * @param keyword
	 * @param session
	 */
	@RequestMapping(value = "viewsearch", method = RequestMethod.GET)
	public String userSearch(String keyword, HttpSession session) {
		//System.out.println(keyword);
		//List<ViewPoint> users = viewPoint();
		//session.setAttribute("users", users);

		return "admin/view/user_list";
	}

	/**
	 * 景点内容 跳转
	 */
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String viewContent(Integer tpVid, Model model) {
		//封装留言信息
		List<Words> lw_list = viewPointService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		List<Reply> lr_list = viewPointService.findByReply();
		model.addAttribute("lr_list",lr_list);

		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		model.addAttribute("viewPoint", viewPoint);

		return "proscenium/viewpoint/content";
	}

	/**
	 * 前台景点模糊搜索
	 */
	@RequestMapping(value = "viewPointSearch", method = RequestMethod.GET)
	public String viewPointSearch(String keyword, Model model) {

		ViewPoint viewPoint = new ViewPoint();
		viewPoint.setTpVname(keyword);
		viewPoint.setTpVtype(keyword);
		viewPoint.setTpLocation(keyword);
		List<ViewPoint> viewPoints = viewPointDao.viewPointSearch(viewPoint);

		model.addAttribute("viewPoints", viewPoints);
		model.addAttribute("msg", Msg.success("景点查询成功!"));

		return "proscenium/viewpoint/view";
	}
}
