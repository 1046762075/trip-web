package com.trip.controller;

import com.trip.commons.AliyunOss;
import com.trip.dao.ForumDao;
import com.trip.dao.HotelDao;
import com.trip.dao.ReplyDao;
import com.trip.dao.TrafficDao;
import com.trip.dao.ViewPointDao;
import com.trip.dao.WordsDao;
import com.trip.service.AdminService;
import com.trip.service.UserService;
import com.trip.service.ViewPointService;
import com.trip.commons.ConstantUtils;
import com.trip.commons.Msg;
import com.trip.commons.TimeStampUtil;
import com.trip.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	@Autowired
	private ViewPointService viewPointService;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private ViewPointDao viewPointDao;
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private TrafficDao trafficDao;
	@Autowired
	private WordsDao wordsDao;
	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private AliyunOss aliyunOss;
	/**
	 * **********login start***************
	 * 从前端跳转到后台登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	/**
	 * 登录逻辑
	 * @param aemail 用户邮箱
	 * @param apwd   密码
	 * @return String
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String aemail, String apwd, HttpSession session) {
		Admin admin = adminService.login(aemail, apwd);
		String timestamp = TimeStampUtil.getTimeFormat();
		//登录失败
		if (admin == null) {
			session.setAttribute("msg", Msg.fail("邮箱或者密码错误!"));
			return login();
		}
		//登录成功
		else {
			// 将登录信息放入session
			session.setAttribute("msg", Msg.success());
			session.setAttribute("timestamp", timestamp);
			session.setAttribute("admin", admin);
			// 明日任务,获取域对象传送user信息
			return "redirect:main";
		}
	}

	/**
	 * 后台注销
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut(HttpSession session) {
		//销毁session
		session.invalidate();
		return login();
	}
	//**********login end***************

	/**
	 * **********main start***************
	 * 登录成功后跳转管理主界面
	 *
	 * @return
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}
	//**********main end***************


	/**********user start***************
	 * 查看用户列表
	 */
	@RequestMapping(value = "userlist", method = RequestMethod.GET)
	public String userList() {
		List<User> users = userService.selectAll();
		session.setAttribute("users", users);
		return "admin/user_list";
	}

	/**
	 * 用户模糊搜索
	 */
	@RequestMapping(value = "usersearch", method = RequestMethod.GET)
	public String userSearch(String keyword, HttpSession session) {
		System.out.println(keyword);
		List<User> users = userService.search(keyword);
		session.setAttribute("users", users);
		session.setAttribute("msg", Msg.success("用户查询成功!"));

		return "admin/user_list";
	}

	/**
	 * 景点模糊搜索
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
		return "admin/view_list";
	}

	/**
	 * 后台酒店模糊搜索
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
		return "admin/hotel_list";
	}

	/**
	 * 后台论坛模糊搜索
	 */
	@RequestMapping(value = "forumPointSearch", method = RequestMethod.GET)
	public String forumPointSearch(String keyword, Model model) {

		Forum forum = new Forum();
		forum.setTpTag(keyword);
		forum.setTpTitle(keyword);
		forum.setTpSubTitle(keyword);
		forum.setTpAuthor(keyword);
		List<Forum> forums = forumDao.forumPointSearch(forum);
		model.addAttribute("forums", forums);
		model.addAttribute("msg", Msg.success("论坛查询成功!"));

		return "admin/forum_list";
	}

	/**
	 * 后台交通列表模糊搜索
	 */
	@RequestMapping(value = "trafficPointSearch", method = RequestMethod.GET)
	public String trafficPointSearch(String keyword, Model model) {

		Traffic traffic = new Traffic();

		traffic.setTpType(keyword);
		traffic.setTpCurrent(keyword);
		traffic.setTpDestination(keyword);
		List<Traffic> traffics = trafficDao.trafficPointSearch(traffic);
		model.addAttribute("traffics", traffics);
		model.addAttribute("msg", Msg.success("交通查询成功!"));

		return "admin/traffic_list";
	}

	/**
	 * 用户单个单击删除
	 */
	@RequestMapping(value = "userdelete", method = RequestMethod.GET)
	public String userDelete(String uid) {
		delAliyunPic(uid, ConstantUtils.ONE);
		userService.userDelete(uid);

		List<User> users = userService.selectAll();
		session.setAttribute("users", users);
		session.setAttribute("msg", Msg.success(uid + "号用户删除成功!"));
		return "admin/user_list";
	}

	private void delAliyunPic(String id, int num) {
		if(num == ConstantUtils.ONE){
			User user = userService.userGet(id);
			if(user != null){
				aliyunOss.delete(user.getUpic());
			}
		} else if(num == ConstantUtils.TWO){
			ViewPoint viewPoint = viewPointService.selectByPrimaryKey(Integer.parseInt(id));
			if(viewPoint != null){
				aliyunOss.delete(viewPoint.getTpVpic());
			}
		} else if(num == ConstantUtils.THREE){
			Hotel hotel = hotelDao.selectByPrimaryKey(Integer.parseInt(id));
			if(hotel != null){
				aliyunOss.delete(hotel.getImgUrl());
			}
		} else {
			System.out.println("未知删除项");
		}
	}

	/**
	 * 用户新增表单跳转
	 */
	@RequestMapping(value = "userform", method = RequestMethod.GET)
	public String userForm() {
		return "admin/user_form";
	}

	/**
	 * 用户新增
	 */
	@RequestMapping(value = "userinsert", method = RequestMethod.POST)
	public String userInsert(String uname, String uemail, String upwd) {
		userService.insertUser(uname, uemail, upwd);
		session.setAttribute("msg", Msg.success("新增用户成功"));
		return "redirect:userlist";
	}

	/**
	 * 用户批量删除功能
	 */
	@RequestMapping(value = "usersectiondelete", method = RequestMethod.GET)
	@ResponseBody
	public String userSectionDelete(String[] uids) {
		for (String uid : uids) {
			delAliyunPic(uid, ConstantUtils.ONE);
			userService.userDelete(uid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(uids) + "号用户批量删除成功!"));
		return "1";
	}

	/**
	 * 跳转用户编辑更新界面
	 */
	@RequestMapping(value = "useredit", method = RequestMethod.GET)
	public String userEdit(String uid) {
		User user = userService.userGet(uid);
		session.setAttribute("user", user);
		return "admin/user_edit";
	}

	/**
	 * 用户更新业务
	 */
	@RequestMapping(value = "useredithandle", method = RequestMethod.POST)
	public String userEditHandle(User user) {
		user.setRegDate(null);
		User dbUser = userService.userGet(user.getUid());
		if(user.getUpic() != null && dbUser != null && !dbUser.getUpic().equals(user.getUpic())){
			delAliyunPic(dbUser.getUid(), ConstantUtils.ONE);
		}
		userService.updataUserInfo(user);
		session.setAttribute("msg", Msg.success("用户信息修改成功!"));
		return "redirect:userlist";
	}
	//**********user start***************


	/************view start***************
	 * 跳转内容管理 景点列表
	 */
	@RequestMapping(value = "viewlist", method = RequestMethod.GET)
	public String viewPoint(ViewPointExample example, Model model) {
		example.setOrderByClause("tp_vid desc");
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		//存储信息转发
		model.addAttribute("viewPoints", viewPoints);
		return "admin/view_list";
	}

	/**
	 * 景点批量删除功能
	 */
	@RequestMapping(value = "viewsectiondelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String viewSectionDelete(Integer[] tpVids) {
		for (Integer tpVid : tpVids) {
			delAliyunPic(tpVid.toString(), ConstantUtils.TWO);
			viewPointService.deleteviews(tpVid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(tpVids) + "号景点批量删除成功!"));
		return "1";
	}

	/**
	 * 景点查看
	 */
	@RequestMapping(value = "viewcontent", method = RequestMethod.GET)
	public String viewcontent(Integer tpVid, Model model) {
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		//前端img标签路径
		model.addAttribute("viewPoint", viewPoint);
		return "admin/view_content";
	}

	/**
	 * 景点单个单击删除
	 */
	@RequestMapping(value = "viewdelete", method = RequestMethod.GET)
	public String viewDelete(Integer tpVid) {
		delAliyunPic(tpVid.toString(), ConstantUtils.TWO);
		viewPointService.deleteviews(tpVid);
		session.setAttribute("msg", Msg.success(tpVid + "号景点删除成功!"));
		return "redirect:viewlist";
	}

	/**
	 * 景点新增表单跳转
	 */
	@RequestMapping(value = "viewform", method = RequestMethod.GET)
	public String viewForm() {
		return "admin/view_form";
	}

	/**
	 * 景点新增
	 */
	@RequestMapping(value = "viewinsert", method = RequestMethod.POST)
	public String viewInsert(ViewPoint viewPoint) {
		viewPoint.setTpCreattime(new Date());
		if (viewPoint.getTpVid() == null) {
			viewPointService.insertView(viewPoint);
			session.setAttribute("msg", Msg.success("新增景点成功!"));
			return "redirect:viewlist";
		}
		session.setAttribute("msg", Msg.fail("新增景点失败!"));
		return "redirect:viewlist";
	}


	/**
	 * 跳转景点编辑更新界面
	 */
	@RequestMapping(value = "viewedit", method = RequestMethod.GET)
	public String viewEdit(Integer tpVid, Model model) {
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		model.addAttribute("viewPoint", viewPoint);
		return "admin/view_edit";
	}

	/**
	 * 跳转景点更新业务
	 */
	@RequestMapping(value = "viewedithandle", method = RequestMethod.POST)
	public String viewEditHandle(ViewPoint viewPoint) {
		ViewPoint DBviewPoint = viewPointService.selectByPrimaryKey(viewPoint.getTpVid());
		if(viewPoint.getTpVpic() != null && DBviewPoint != null && !DBviewPoint.getTpVpic().equals(viewPoint.getTpVpic())){
			aliyunOss.delete(DBviewPoint.getTpVpic());
		}
		viewPointService.updateByPrimaryKeySelective(viewPoint);
		session.setAttribute("msg", Msg.success("景点信息更新成功!"));
		return "redirect:viewlist";
	}

	//**********view end***************

	/*************hotel ************
	 * 酒店管理列表
	 */
	@RequestMapping(value = "hotellist", method = RequestMethod.GET)
	public String hotelList(Model model) {
		HotelExample example = new HotelExample();

		example.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(example);
		model.addAttribute("hotels", hotels);

		return "admin/hotel_list";
	}

	/**
	 * 跳转
	 * 酒店管理列表
	 */
	@RequestMapping(value = "hotelcontent", method = RequestMethod.GET)
	public String hotelContent(Integer hid, Model model) {

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);
		//前端img标签路径
		model.addAttribute("hotel", hotel);

		return "admin/hotel_content";
	}

	/**
	 * 跳转酒店编辑
	 */
	@RequestMapping(value = "hoteledit", method = RequestMethod.GET)
	public String hotelEdit(Integer hid, Model model) {

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);

		model.addAttribute("hotel", hotel);
		return "admin/hotel_edit";
	}

	/**
	 * 酒店编辑
	 */
	@RequestMapping(value = "hoteledithandle", method = RequestMethod.POST)
	public String hotelEditHandle(Hotel hotel) {
		Hotel DBhotel = hotelDao.selectByPrimaryKey(hotel.getHid());
		if(hotel.getImgUrl() != null && DBhotel != null && !hotel.getImgUrl().equals(DBhotel.getImgUrl())) {
			delAliyunPic(DBhotel.getHid().toString(), ConstantUtils.THREE);
		}
		hotelDao.updateByPrimaryKeySelective(hotel);
		session.setAttribute("msg", Msg.success("酒店信息编辑成功!"));
		return "redirect:hotellist";
	}

	/**
	 * 酒店删除业务
	 */
	@RequestMapping(value = "hoteldelete", method = RequestMethod.GET)
	public String hotelDelete(Integer hid) {
		delAliyunPic(hid.toString(), ConstantUtils.THREE);
		hotelDao.deleteByPrimaryKey(hid);
		session.setAttribute("msg", Msg.success("删除酒店成功!"));
		return "redirect:hotellist";
	}

	/**
	 * 酒店批量删除
	 */
	@RequestMapping(value = "hotelMutiDelete", method = RequestMethod.GET)
	@ResponseBody
	public String hotelMutiDelete(Integer[] hids) {
		for (Integer hid : hids) {
			delAliyunPic(hid.toString(), ConstantUtils.THREE);
			hotelDao.deleteByPrimaryKey(hid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(hids) + "号酒店批量删除成功!"));
		return "1";
	}

	/**
	 * 酒店
	 * 新增表单跳转
	 */
	@RequestMapping(value = "hotelInsertForm", method = RequestMethod.GET)
	public String hotelInsertForm() {
		return "admin/hotel_insert";
	}

	/**
	 * 酒店新增
	 */
	@RequestMapping(value = "hotelInsert", method = RequestMethod.POST)
	public String hotelInsert(Hotel hotel, Model model) {
		if (hotel.getHid() == null) {
			hotelDao.insertSelective(hotel);
			model.addAttribute("msg", Msg.success("酒店新增成功!"));
			return "redirect:hotellist";
		}
		model.addAttribute("msg", Msg.fail("酒店新增失败!"));
		return "redirect:hoteledit";
	}

	/**
	 * content
	 */
	@RequestMapping(value = "forumList", method = RequestMethod.GET)
	public String forumList(Model model) {
		ForumExample example = new ForumExample();
		example.setOrderByClause("tp_fid desc");

		List<Forum> forums = forumDao.selectByExample(example);

		model.addAttribute("forums", forums);

		return "admin/forum_list";
	}

	/**
	 * @param tpFids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "forumMutiDelete", method = RequestMethod.GET)
	public String forumMutiDelete(Integer[] tpFids) {
		for (Integer tpFid : tpFids) {
			forumDao.deleteByPrimaryKey(tpFid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(tpFids) + "号批量删除成功!"));
		return "1";
	}

	/**
	 * forummutidelete
	 */
	@RequestMapping(value = "forumDelete", method = RequestMethod.GET)
	public String forumDelete(Integer tpFid, Model model) {
		forumDao.deleteByPrimaryKey(tpFid);
		model.addAttribute("msg", Msg.success(tpFid + "号删除成功!"));
		return "redirect:forumList";
	}

	/**
	 * 帖子
	 * 新增表单跳转
	 */
	@RequestMapping(value = "forumInsertForm", method = RequestMethod.GET)
	public String forumInsertForm() {
		return "admin/forum_insert";
	}

	/**
	 * 帖子新增
	 */
	@RequestMapping(value = "forumInsert", method = RequestMethod.POST)
	public String forumInsert(Forum forum, Model model) {
		User user = userService.findIdByName(forum.getTpAuthor());
		forum.setTpAuthorId(user == null?0:Integer.parseInt(user.getUid()));
		forum.setTpIssueTime(new Date());
		if (forum.getTpFid() == null) {
			forumDao.insert(forum);
			model.addAttribute("msg", Msg.success("新增帖子成功!"));
			return "redirect:forumList";
		}
		model.addAttribute("msg", Msg.fail("新增帖子失败!"));
		return "redirect:forumList";
	}

	/**
	 * 帖子编辑
	 */
	@RequestMapping(value = "forumEditForm", method = RequestMethod.GET)
	public String forumEditForm(Integer tpFid, Model model) {
		Forum forum = forumDao.selectByPrimaryKey(tpFid);
		model.addAttribute("forum", forum);
		return "admin/forum_edit";
	}

	/**
	 * 帖子更新
	 */
	@RequestMapping(value = "forumEdit", method = RequestMethod.POST)
	public String forumEdit(Forum forum, Model model) {
		forumDao.updateByPrimaryKeySelective(forum);
		model.addAttribute("msg", Msg.success("更新成功!"));
		return "redirect:forumList";
	}

	/**Traffic**
	 * 跳转交通列表页面
	 */
	@RequestMapping(value = "trafficList", method = RequestMethod.GET)
	public String trafficList(Model model) {
		TrafficExample example = new TrafficExample();
		example.setOrderByClause("tp_Tid desc");
		List<Traffic> traffics = trafficDao.selectByExample(example);

		model.addAttribute("traffics", traffics);
		return "admin/traffic_list";
	}

	/**
	 * 跳转交通新增页面
	 * @return
	 */
	@RequestMapping(value = "trafficInsert", method = RequestMethod.GET)
	public String trafficInsert() {
		return "admin/traffic_insert";
	}

	/**
	 * 提交新增信息
	 * @return
	 */
	@RequestMapping(value = "trafficInsertHandler", method = RequestMethod.POST)
	public String trafficInsertHandler(Traffic traffic, String currentTime, String arriveTime, Model model) {
		try {
			traffic.setTpCurrentTime(currentTime);
			traffic.setTpArriveTime(arriveTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		trafficDao.insertSelective(traffic);
		model.addAttribute("msg",Msg.success("新增交通信息成功！"));
		return "redirect:trafficList";
	}

	/**
	 * 单机删除
	 * @return
	 */
	@RequestMapping(value = "trafficDelete", method = RequestMethod.GET)
	public String trafficDelete(Integer tpTid, Model model) {
		trafficDao.deleteByPrimaryKey(tpTid);
		model.addAttribute("msg", Msg.success(tpTid + "号删除成功！"));
		return "redirect:trafficList";
	}
	/**
	 * 批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "trafficMutiDelete", method = RequestMethod.GET)
	public String trafficsMutiDelete(Integer[] tpTras, Model model) {

		for (Integer tpTid : tpTras){
			trafficDao.deleteByPrimaryKey(tpTid);
		}
		model.addAttribute("msg", Msg.success(Arrays.toString(tpTras) + "号删除成功！"));
		return "1";
	}

	/**
	 * 跳转交通编辑页面
	 * @return String
	 */
	@RequestMapping(value = "trafficEdit", method = RequestMethod.GET)
	public String trafficEdit(Integer tpTid, Model model) {
		Traffic traffic = trafficDao.selectByPrimaryKey(tpTid);

		model.addAttribute("traffic", traffic);
		return "admin/traffic_edit";
	}

	/**
	 * 交通编辑
	 * @return
	 */
	@RequestMapping(value = "trafficEditHandle", method = RequestMethod.POST)
	public String trafficEditHandle(Traffic traffic, String currentTime, String arriveTime, Model model) {
		try {
			traffic.setTpCurrentTime(currentTime);
			traffic.setTpArriveTime(arriveTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		trafficDao.updateByPrimaryKeySelective(traffic);
		model.addAttribute("msg",Msg.success("更新成功！"));
		return "redirect:trafficList";
	}

	/**
	 * 跳转评论列表
	 * @return
	 */
	@RequestMapping(value = "wordsList", method = RequestMethod.GET)
	public String wordsList(Model model) {
		List<Words> byWords = viewPointService.findByWords();
		model.addAttribute("byWords", byWords);
		return "admin/words_list";
	}

	/**
	 * 留言批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "wordsMutiDelete", method = RequestMethod.GET)
	public String wordsMutiDelete(Integer[] lw_ids, Model model) {

		for (Integer lw_id : lw_ids){
			wordsDao.deleteByPrimaryKey(lw_id);

		}
		model.addAttribute("msg", Msg.success(Arrays.toString(lw_ids) + "号删除成功！"));
		return "1";
	}

	/**
	 * 单击删除
	 * @return
	 */
	@RequestMapping(value = "wordsDelete", method = RequestMethod.GET)
	public String wordsDelete(Integer lw_id, Model model) {
		wordsDao.deleteByPrimaryKey(lw_id);
		model.addAttribute("msg", Msg.success(lw_id + "号删除成功！"));
		return "redirect:wordsList";
	}

	/**
	 * 跳转回复列表
	 * @return
	 */
	@RequestMapping(value = "replyList", method = RequestMethod.GET)
	public String ReplyList(Model model) {
		List<Reply> replys = viewPointService.findByReply();
		model.addAttribute("replys", replys);
		return "admin/reply_list";
	}

	/**
	 * 回复批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "replyMutiDelete", method = RequestMethod.GET)
	public String replyMutiDelete(Integer[] lr_ids, Model model) {
		for (Integer lr_id : lr_ids){
			replyDao.deleteByPrimaryKey(lr_id);
		}
		model.addAttribute("msg", Msg.success(Arrays.toString(lr_ids) + "号删除成功！"));
		return "1";
	}

	/**
	 * 单击删除
	 * @return
	 */
	@RequestMapping(value = "replyDelete", method = RequestMethod.GET)
	public String replyDelete(Integer lr_id, Model model) {
		replyDao.deleteByPrimaryKey(lr_id);
		model.addAttribute("msg", Msg.success(lr_id + "号删除成功！"));
		return "redirect:replyList";
	}
}