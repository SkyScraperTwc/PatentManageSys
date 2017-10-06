package com.scut.crm.action;

import com.scut.crm.constant.PageReturnConst;
import com.scut.crm.entity.User;
import com.scut.crm.service.impl.AuthorityServiceImpl;
import com.scut.crm.utils.ScopeUtils;
import com.scut.crm.web.vo.LoginRequest;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

@Data
@Controller
@Scope("prototype")
@Log4j
public class AuthorityAction {

    private LoginRequest loginRequest;

    @Autowired
    private AuthorityServiceImpl authorityService;

    /**
     * 用户登录
     */
    public String login() throws Exception {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        boolean loginFlag = authorityService.login(username, password);
        if(loginFlag){
            return PageReturnConst.LOGIN_SUCCESS;
        }else {
            return PageReturnConst.TOLOGIN;
        }
    }

    /**
     * 用户注销
     */
    public String logout() throws Exception {
        HttpSession session = ScopeUtils.getHttpSession();
        User user = (User) session.getAttribute("user");
        if (null!=user){
            session.removeAttribute("user");
        }
        return PageReturnConst.TOLOGIN;
    }

    /**
     * 登录页面
     */
    public String toLogin() throws Exception {
        return PageReturnConst.TOLOGIN;
    }
}
