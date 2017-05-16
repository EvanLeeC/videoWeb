package net.video.service;

import java.io.Serializable;

/**
 * <p>TODO 类描述</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月10日
 */
public interface BaseService <T, ID extends Serializable>{

	/**
	 * 查找实体对象
	 * 
	 * @param id ID
	 * @return 实体对象，若不存在则返回null
	 */
	T find(ID id);
	
	/**
	 * 保存实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void save(T entity);
	
	/**
	 * 保存实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void save(@SuppressWarnings("unchecked") T... entitys);

	/**
	 * 更新实体对象
	 * 
	 * @param entity 实体对象
	 * @return 实体对象
	 */
	T update(T entity);

	/**
	 * 删除实体对象
	 * 
	 * @param id ID
	 */
	void delete(ID id);

	/**
	 * 删除实体对象
	 * 
	 * @param ids ID
	 */
	void delete(@SuppressWarnings("unchecked") ID... ids);

	/**
	 * 删除实体对象
	 * 
	 * @param entity 实体对象
	 */
	void delete(T entity);
	
	/**
	 * 更新实体对象
	 * 
	 * @param entity 实体对象
	 * @param ignoreProperties 忽略属性
	 * @return 实体对象
	 */
	T update(T entity, String... ignoreProperties);

}
