package com.scut.crm.service.impl;

import com.scut.crm.constant.PaginationPropertyConst;
import com.scut.crm.dao.impl.BaseDaoImpl;
import com.scut.crm.entity.Pagination;
import com.scut.crm.entity.Patent;
import com.scut.crm.service.AbstractBaseService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Log4j
public class PatentServiceImpl extends AbstractBaseService<Patent> {

    @Autowired
    private BaseDaoImpl baseDao;

    @Override
    public Pagination<Patent> listByPage(Map<String, Object> map) {
        String hql = "select patent from Patent patent where 1=1";
        StringBuffer joint = new StringBuffer("");

        String currentPage = (String) map.get("currentPage");
        if(null==currentPage || currentPage.isEmpty()){
            /**currentPage=1*/
            currentPage = String.valueOf(PaginationPropertyConst.PAGE_CURRENT_ONE);
        }
        /**获取totalRecords*/
        int totalRecords = this.getTotalRecords(joint.toString(), null);
        /**查询patentSet*/
        List<Patent> dataList = baseDao.queryByPage(hql, null, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN);
        /**构建pagination*/
        Pagination<Patent> pagination = new Pagination<>(totalRecords, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN, dataList);
        return pagination;
    }

    /**
     * 根据外键authorId查询
     * @param map
     * @return
     */
    @Override
    public Pagination<Patent> listByForeignKey(Map<String,Object> map) {
        String hql = "select patent from Patent patent where 1=1";
        List<Object> paramList = new ArrayList<>();
        StringBuffer joint = new StringBuffer("");

        String currentPage = (String) map.get("currentPage");
        String authorId = (String) map.get("authorId");
        if(null==currentPage || currentPage.isEmpty()){
            /**currentPage=1*/
            currentPage = String.valueOf(PaginationPropertyConst.PAGE_CURRENT_ONE);
        }
        if(null!=authorId && !authorId.isEmpty()){
            joint.append(" and patent.author.id=?");
            paramList.add(Integer.valueOf(authorId));
        }
        hql = hql + joint.toString();
        int totalRecords = this.getTotalRecords(joint.toString(), paramList.toArray());

        List<Patent> dataList = baseDao.queryByPage(hql, paramList.toArray(), Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN);

        Pagination<Patent> pagination = new Pagination<>(totalRecords, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN, dataList);
        return pagination;
    }

    @Override
    public int getTotalRecords(String joint, Object[] params) {
        String hql = "select count(*) from Patent patent where 1=1";
        hql = hql + joint;
        int totalRecords = baseDao.count(hql, params);
        log.info("getTotalRecords----hql---"+hql);
        log.info("getTotalRecords----totalRecords----"+totalRecords);
        return totalRecords;
    }

    @Override
    public Patent getById(Integer id) {
        return (Patent) baseDao.get(Patent.class, id);
    }

    @Override
    public Patent getBySerialNumber(String serialNumber) {
        return null;
    }

}
