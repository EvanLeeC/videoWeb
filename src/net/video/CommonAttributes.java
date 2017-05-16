/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package net.video;

/**
 * <p>公共参数</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月16日
 */
public final class CommonAttributes {

	/** 日期格式配比 */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss" };

	/** videoweb.properties文件路径 */
	public static final String SHOPXX_PROPERTIES_PATH = "/videoweb.properties";
	
	/** shopxx.xml文件路径 */
	public static final String VIDEO_XML_PATH = "/video.xml";
	
	/**
	 * 不可实例化
	 */
	private CommonAttributes() {
	}

}