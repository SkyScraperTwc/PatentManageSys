package com.scut.crm.utils.convert;

import com.scut.crm.entity.Author;
import com.scut.crm.entity.User;
import com.scut.crm.utils.convert.base.SuperConvertUtils;
import com.scut.crm.web.vo.query.AuthorQueryRequest;
import com.scut.crm.web.vo.save.AuthorSaveRequest;
import com.scut.crm.web.vo.update.AuthorUpdateRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Entity转换工具类
 */

public final class AuthorConvertUtils extends SuperConvertUtils{
    /**
     * authorSaveRequest ——> author
     * @param saveRequest
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Author fromSaveRequest2Author(AuthorSaveRequest saveRequest, String serialNumber, User user) throws InvocationTargetException, IllegalAccessException {
        Author author = new Author();
        BeanUtils.setProperty(author,"id",null);
        BeanUtils.setProperty(author,"serialNumber", serialNumber);
        BeanUtils.setProperty(author,"name",saveRequest.getName());
        BeanUtils.setProperty(author,"phone",saveRequest.getPhone());
        BeanUtils.setProperty(author,"address",saveRequest.getAddress());
        BeanUtils.setProperty(author,"patentSet",null);
        BeanUtils.setProperty(author,"user",user);
        BeanUtils.setProperty(author,"createTime",new Date());
        BeanUtils.setProperty(author,"editTime",new Date());
        return author;
    }

    /**
     * authorQueryRequest ——> author
     * @param queryRequest
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Map<String,Object> fromQueryRequest2Author(AuthorQueryRequest queryRequest) throws InvocationTargetException, IllegalAccessException {
        if(null!=queryRequest){
            Map<String,Object> map = new HashMap<>();
            Author author = new Author();
            BeanUtils.setProperty(author,"serialNumber",queryRequest.getSerialNumber());
            BeanUtils.setProperty(author,"name",queryRequest.getName());
            BeanUtils.setProperty(author,"phone",queryRequest.getPhone());
            String currentPage = queryRequest.getCurrentPage();
            map.put("currentPage",currentPage);
            map.put("author",author);
            return map;
        }else {
            return null;
        }
    }

    /**
     * author——>authorUpdateRequest
     * @param author
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static AuthorUpdateRequest fromAuthor2UpdateRequest(Author author) throws InvocationTargetException, IllegalAccessException {
        AuthorUpdateRequest updateRequest = new AuthorUpdateRequest();
        BeanUtils.setProperty(updateRequest,"id",author.getId());
        BeanUtils.setProperty(updateRequest,"serialNumber",author.getSerialNumber());
        BeanUtils.setProperty(updateRequest,"name",author.getName());
        BeanUtils.setProperty(updateRequest,"phone",author.getPhone());
        BeanUtils.setProperty(updateRequest,"address",author.getAddress());
        return updateRequest;
    }

    /**
     * updateRequest——>author
     * @param updateRequest
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Author fromUpdateRequest2Author(AuthorUpdateRequest updateRequest, User user) throws InvocationTargetException, IllegalAccessException {
        Author author = new Author();
        BeanUtils.setProperty(author,"id",updateRequest.getId());
        BeanUtils.setProperty(author,"serialNumber", updateRequest.getSerialNumber());
        BeanUtils.setProperty(author,"name",updateRequest.getName());
        BeanUtils.setProperty(author,"phone",updateRequest.getPhone());
        BeanUtils.setProperty(author,"address",updateRequest.getAddress());
        BeanUtils.setProperty(author,"patentSet",null);
        BeanUtils.setProperty(author,"user",user);
        BeanUtils.setProperty(author,"createTime",new Date());
        BeanUtils.setProperty(author,"editTime",new Date());
        return author;
    }

}
