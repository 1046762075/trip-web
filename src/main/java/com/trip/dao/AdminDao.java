package com.trip.dao;

import com.trip.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
	/**
	 *
	 * @param admin
	 * @return
	 */
	Admin selectAdmin(Admin admin);


	List<Admin> selectAll();
}
