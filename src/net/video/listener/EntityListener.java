package net.video.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import net.video.entity.BaseEntity;

/**
 * <p>TODO 类描述</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月10日
 */
public class EntityListener {

	/**
	 * 保存前处理
	 * 
	 * @param entity 基类
	 */
	@PrePersist
	public void prePersist(BaseEntity entity) {
		entity.setCreateDate(new Date());
		entity.setModifyDate(new Date());
	}

	/**
	 * 更新前处理
	 * 
	 * @param entity 基类
	 */
	@PreUpdate
	public void preUpdate(BaseEntity entity) {
		entity.setModifyDate(new Date());
	}
}
