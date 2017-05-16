package net.video.dao;

import java.io.Serializable;

/**
 * <p>TODO 类描述</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月10日
 */
public interface BaseDao<T, ID extends Serializable> {


	/**
	 * 查找实体对象
	 * 
	 * @param id ID
	 * @return 实体对象，若不存在则返回null
	 */
	T find(ID id);
	
	/**
	 * 持久化实体对象
	 * 
	 * @param entity 实体对象
	 */
	void persist(T entity);

	/**
	 * 合并实体对象
	 * 
	 * @param entity 实体对象
	 * @return 实体对象
	 */
	T merge(T entity);
	
	/**
	 * 移除实体对象
	 * 
	 * @param entity 实体对象
	 */
	void remove(T entity);

	/**
	 * 刷新实体对象
	 * 
	 * @param entity 实体对象
	 */
	void refresh(T entity);

	/**
	 * 清除缓存
	 */
	void clear();

	/**
	 * 同步数据
	 */
	void flush();
}
