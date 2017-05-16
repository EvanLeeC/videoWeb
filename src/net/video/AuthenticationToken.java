package net.video;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * <p>登录令牌</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月16日
 */
public class AuthenticationToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 5898441540965086534L;

	/**
	 * @param username 用户名
	 * @param password 密码
	 * @param rememberMe 记住我
	 * @param host IP
	 */
	public AuthenticationToken(String username, String password, boolean rememberMe, String host) {
		super(username, password, rememberMe, host);
	}

}