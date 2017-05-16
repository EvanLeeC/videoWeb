package net.video.service;

import java.util.List;

import net.video.entity.Admin;

/**
 * <p>Service - 管理员</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月16日
 */
public interface AdminService extends BaseService<Admin, Long> {

	/**
	 * 根据用户名查询管理员
	 * @param username
	 * @return Admin
	 */
	Admin findByUsername(String username);

	/**
	 * 根据id查询权限
	 * @param id
	 * @return List<String>
	 */
	List<String> findAuthorities(Long id);
	
}