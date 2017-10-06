package com.scut.crm.service.impl;

import com.scut.crm.constant.EntityNumberConst;
import com.scut.crm.dao.impl.BaseDaoImpl;
import com.scut.crm.entity.User;
import com.scut.crm.utils.ScopeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
public class AuthorityServiceImpl {

    @Autowired
    private BaseDaoImpl baseDao;

    public boolean login(String username, String password) {
        String hql = "select user from User user where user.username=?";
        Object[] param = {username};
        User user = (User) baseDao.queryOne(hql, param);
        if (null!=user && user.getPassword().equals(password)){
            HttpSession session = ScopeUtils.getHttpSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(EntityNumberConst.NEGATIVE_ONE);
            return true;
        }else {
            return false;
        }
    }
}
