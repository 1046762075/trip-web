package com.trip.service.impl;

import com.trip.dao.UserDao;
import com.trip.service.UserService;
import com.trip.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void insertUser(String uname, String uemail, String upwd) {
		userDao.insertUser(new User(uname, uemail, upwd));
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> search(String keyword) {
		User user = new User();
		user.setUid(keyword);
		user.setUname(keyword);
		user.setUemail(keyword);
		return userDao.search(user);
	}

	@Override
	public void userDelete(String uid) {
		userDao.userDelete(uid);
	}

	@Override
	public User userLogin(User user) {
		User loginUser = userDao.userLogin(user);
		return loginUser;
	}

	@Override
	public User userGet(String uid) {
		return userDao.userGet(uid);
	}

	@Override
	public void updataUserInfo(User user) {
		userDao.updataUserInfo(user);
	}

	@Override
	public User findIdByName(String tpAuthor) {
		return userDao.findIdByName(tpAuthor);
	}
}
