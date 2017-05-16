package net.video.controller;

import net.video.utils.SpringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

/**
 * <p>TODO 类描述</p>
 *
 * @author  lxy
 * @version 3.0!
 * @date    2017年5月10日
 */
@Scope(value = "prototype")
public class BaseController {
    /** logger */
    @SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    /**
	 * 获取国际化消息
	 * 
	 * @param code 代码
	 * @param args 参数
	 * @return 国际化消息
	 */
	protected String message(String code, Object... args) {
		return SpringUtils.getMessage(code, args);
	}
        
}
