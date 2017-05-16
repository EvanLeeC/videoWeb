package net.video.service.impl;

import java.io.Serializable;

import net.video.dao.BaseDao;
import net.video.service.BaseService;

import org.springframework.transaction.annotation.Transactional;

/**
 * <p>TODO 类描述</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月10日
 */
public class BaseServiceImpl <T, ID extends Serializable> implements BaseService<T, ID>{

	/** baseDao */
	private BaseDao<T, ID> baseDao;

	public void setBaseDao(BaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	@Transactional
	public T find(ID id) {
		return baseDao.find(id);
	}

	@Override
	@Transactional
	public void save(T entity) {
		baseDao.persist(entity);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public void save(T... entitys) {
		for (T entity : entitys) {
			baseDao.persist(entity);
		}
	}

	@Override
	@Transactional
	public T update(T entity) {
		return baseDao.merge(entity);
	}

	@Override
	@Transactional
	public void delete(ID id) {
		delete(baseDao.find(id));
	}

	@Override
	@Transactional
	public void delete(ID... ids) {
		if (ids != null) {
			for (ID id : ids) {
				delete(baseDao.find(id));
			}
		}
	}

	@Override
	@Transactional
	public void delete(T entity) {
		baseDao.remove(entity);
	}

}
