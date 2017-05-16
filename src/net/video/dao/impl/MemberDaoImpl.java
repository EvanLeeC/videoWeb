package net.video.dao.impl;

import net.video.dao.MemberDao;
import net.video.entity.Member;

import org.springframework.stereotype.Repository;

/**
 * <p>TODO 类描述</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月10日
 */
@Repository("memberDaoImpl")
public class MemberDaoImpl extends BaseDaoImpl<Member, Long> implements MemberDao {
	
}
