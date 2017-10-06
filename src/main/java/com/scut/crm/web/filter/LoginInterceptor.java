package com.scut.crm.web.filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.scut.crm.constant.PageReturnConst;
import com.scut.crm.entity.User;
import com.scut.crm.utils.ScopeUtils;

import java.util.Map;

public class LoginInterceptor implements Interceptor {

	private String[] urls;

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		this.urls = new String[]{"/authorityAction/login.action", "/authorityAction/toLogin.action"};
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/**请求通过*/
		String servletPath = ScopeUtils.getRequest().getServletPath();
		for (String url : urls) {
			if(url.equals(servletPath)){
				return invocation.invoke();
			}
		}

		Map<String, Object> session = invocation.getInvocationContext().getSession();
		User user = (User) session.get("user");
		if(null == user){
			return PageReturnConst.TOLOGIN;
		}else{
			return invocation.invoke();
		}
	}

}
