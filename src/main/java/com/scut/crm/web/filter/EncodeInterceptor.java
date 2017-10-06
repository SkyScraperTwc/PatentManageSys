package com.scut.crm.web.filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.scut.crm.utils.ScopeUtils;
import lombok.extern.log4j.Log4j;

import javax.servlet.http.HttpServletRequest;

@Log4j
public class EncodeInterceptor implements Interceptor {

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		log.info("EncodeInterceptor...");
		HttpServletRequest request = ScopeUtils.getRequest();
		request.setCharacterEncoding("UTF-8");
		return invocation.invoke();
	}

}
