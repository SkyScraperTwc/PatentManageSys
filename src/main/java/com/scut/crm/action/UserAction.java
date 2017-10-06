package com.scut.crm.action;

import com.scut.crm.constant.PageReturnConst;
import com.scut.crm.entity.User;
import com.scut.crm.entity.Pagination;
import com.scut.crm.service.impl.UserServiceImpl;
import com.scut.crm.utils.ScopeUtils;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Data
@Controller
@Scope("prototype")
@Log4j
public class UserAction {

	private User user;

	private String currentPage;

	@Autowired
	private UserServiceImpl userService;

	public String list() throws InvocationTargetException, IllegalAccessException {
		Map<String,Object> map = new HashMap<>();
		map.put("currentPage",currentPage);
		Pagination<User> pagination = userService.listByPage(map);
		ScopeUtils.getRequestMap().put("pagination",pagination);
		/**返回到主页面*/
		return PageReturnConst.USER_INDEX;
	}

}
