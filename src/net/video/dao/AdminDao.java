package net.video.dao;

import net.video.entity.Admin;


/**
 * 
 * <p>Dao - 管理员</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月16日
 */
public interface AdminDao extends BaseDao<Admin, Long> {

	/**
	 * 根据用户名查询管理员
	 * @param username
	 * @return Admin
	 */
	Admin findByUsername(String username);

}