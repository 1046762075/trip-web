package com.trip.service;

import com.trip.domain.Admin;

import java.util.List;

public interface AdminService {
	Admin login(String eamil, String pwd);

	List<Admin> selectAll();
}
