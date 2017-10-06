package com.scut.crm.service.impl;

import com.scut.crm.constant.PaginationPropertyConst;
import com.scut.crm.dao.impl.BaseDaoImpl;
import com.scut.crm.entity.User;
import com.scut.crm.entity.Pagination;
import com.scut.crm.service.AbstractBaseService;
import com.scut.crm.utils.ScopeUtils;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
@Log4j
public class UserServiceImpl extends AbstractBaseService<User>{

    @Autowired
    private BaseDaoImpl baseDao;

    @Override
    public Pagination<User> listByPage(Map<String, Object> map) {
        log.info("map---"+map);
        String hql = "select user from User user where 1=1";
        StringBuffer joint = new StringBuffer("");

        String currentPage = (String) map.get("currentPage");
        if(null==currentPage || currentPage.isEmpty()){
            /**currentPage=1*/
            currentPage = String.valueOf(PaginationPropertyConst.PAGE_CURRENT_ONE);
        }
        /**获取totalRecords*/
        int totalRecords = this.getTotalRecords(joint.toString(), null);
        /**查询userList*/
        List<User> dataList = baseDao.queryByPage(hql, null, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN);
        /**构建pagination*/
        Pagination<User> pagination = new Pagination<>(totalRecords, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN, dataList);
        return pagination;
    }

    @Override
    public Pagination<User> listByForeignKey(Map<String,Object> map) {
        return null;
    }

    @Override
    public int getTotalRecords(String joint, Object[] params) {
        String hql = "select count(*) from User user where 1=1";
        hql = hql + joint;
        int totalRecords = baseDao.count(hql, params);
        log.info("getTotalRecords----hql---"+hql);
        log.info("getTotalRecords----totalRecords----"+totalRecords);
        return totalRecords;
    }

    @Override
    public User getById(Integer id) {
        return (User) baseDao.get(User.class,id);
    }

    @Override
    public User getBySerialNumber(String serialNumber) {
        return null;
    }
}
