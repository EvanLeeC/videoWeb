/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package net.video.filter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.video.AuthenticationToken;
import net.video.service.RSAService;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * Filter - 权限认证
 * 
 * @author SHOP++ Team
 * @version 3.0
 */
public class AuthenticationFilter extends FormAuthenticationFilter {

	/** 默认"加密密码"参数名称 */
	private static final String DEFAULT_EN_PASSWORD_PARAM = "enPassword";

	/** "加密密码"参数名称 */
	private String enPasswordParam = DEFAULT_EN_PASSWORD_PARAM;


	@Resource(name = "rsaServiceImpl")
	private RSAService rsaService;

	@Override
	protected org.apache.shiro.authc.AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
		String username = getUsername(servletRequest);
		String password = getPassword(servletRequest);
		boolean rememberMe = isRememberMe(servletRequest);
		String host = getHost(servletRequest);
		return new AuthenticationToken(username, password, rememberMe, host);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			response.addHeader("loginStatus", "accessDenied");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		return super.onAccessDenied(request, response);
	}

	@Override
	protected boolean onLoginSuccess(org.apache.shiro.authc.AuthenticationToken token, Subject subject, ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		Session session = subject.getSession();
		Map<Object, Object> attributes = new HashMap<Object, Object>();
		Collection<Object> keys = session.getAttributeKeys();
		for (Object key : keys) {
			attributes.put(key, session.getAttribute(key));
		}
		session.stop();
		session = subject.getSession();
		for (Entry<Object, Object> entry : attributes.entrySet()) {
			session.setAttribute(entry.getKey(), entry.getValue());
		}
		return super.onLoginSuccess(token, subject, servletRequest, servletResponse);
	}

	@Override
	protected String getPassword(ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String password = rsaService.decryptParameter(enPasswordParam, request);
		rsaService.removePrivateKey(request);
		return password;
	}

	/**
	 * 获取"加密密码"参数名称
	 * 
	 * @return "加密密码"参数名称
	 */
	public String getEnPasswordParam() {
		return enPasswordParam;
	}

	/**
	 * 设置"加密密码"参数名称
	 * 
	 * @param enPasswordParam
	 *            "加密密码"参数名称
	 */
	public void setEnPasswordParam(String enPasswordParam) {
		this.enPasswordParam = enPasswordParam;
	}

}