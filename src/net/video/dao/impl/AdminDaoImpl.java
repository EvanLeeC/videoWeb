/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package net.video.dao.impl;

import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;

import net.video.dao.AdminDao;
import net.video.entity.Admin;

import org.springframework.stereotype.Repository;

/**
 * 
 * <p>Dao - 管理员</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月16日
 */
@Repository("adminDaoImpl")
public class AdminDaoImpl extends BaseDaoImpl<Admin, Long> implements AdminDao {

	@Override
	public Admin findByUsername(String username) {
		if (username == null) {
			return null;
		}
		try {
			String jpql = "select admin from Admin admin where lower(admin.username) = lower(:username)";
			return entityManager.createQuery(jpql, Admin.class).setFlushMode(FlushModeType.COMMIT).setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}