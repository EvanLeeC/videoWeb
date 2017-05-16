package net.video.controller;

import javax.annotation.Resource;

import net.video.service.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>TODO 类描述</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月10日
 */
@Controller("adminMemberController")
@RequestMapping("/admin/member")
public class MemberController extends BaseController {
	@Resource(name = "memberServiceImpl")
	private MemberService memberService;

	/**
	 * 测试
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView checkUsername() {
		System.out.println("Hello World!");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/test");
		return modelAndView;
	}
}
