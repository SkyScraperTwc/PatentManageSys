package com.scut.crm.utils;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 域获取工具类
 * 推荐静态，不推荐单例模式
 */
public final class ScopeUtils {
	/**
	 * 获取HttpServletRequest
	 */
	public static HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	/**
	 * 获取HttpSession
	 */
	public static HttpSession getHttpSession(){
		return ServletActionContext.getRequest().getSession();
	}
	/**
	 * 获取sessionMap
	 */
	public static Map<String,Object> getSessionMap(){
		return ActionContext.getContext().getSession();
	}

	/**
	 * 获取applicationMap
	 */
	public static Map<String,Object> getApplicationMap(){
		return ActionContext.getContext().getApplication();
	}
	/**
	 * 获取requestMap
	 */
	public static Map<String,Object> getRequestMap(){
		return (Map)ActionContext.getContext().get("request");
	}


}
