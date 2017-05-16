package net.video.service.impl;

import javax.annotation.Resource;

import net.video.dao.MemberDao;
import net.video.entity.Member;
import net.video.service.MemberService;

import org.springframework.stereotype.Service;

/**
 * <p>TODO 类描述</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月10日
 */
@Service("memberServiceImpl")
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService {
	
	@Resource(name = "memberDaoImpl")
	private MemberDao memberDao;
	@Resource(name = "memberDaoImpl")
    public void setBaseDao(MemberDao memberDao) {
        super.setBaseDao(memberDao);
    }
	
}
