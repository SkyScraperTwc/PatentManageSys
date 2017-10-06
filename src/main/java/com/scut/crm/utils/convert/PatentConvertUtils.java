package com.scut.crm.utils.convert;

import com.scut.crm.constant.PropertyMapConst;
import com.scut.crm.entity.Author;
import com.scut.crm.entity.Patent;
import com.scut.crm.utils.convert.base.SuperConvertUtils;
import com.scut.crm.web.vo.save.PatentSaveRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Entity转换工具类
 */

public final class PatentConvertUtils extends SuperConvertUtils{

    public static Patent fromSaveRequest2Patent(PatentSaveRequest saveRequest, String serialNumber, Author author) throws InvocationTargetException, IllegalAccessException {
        Patent patent = new Patent();
        BeanUtils.setProperty(patent,"id",null);
        BeanUtils.setProperty(patent,"serialNumber",serialNumber);
        BeanUtils.setProperty(patent,"name",saveRequest.getName());
        BeanUtils.setProperty(patent,"type",getValue(getUnmodifiableMap(PropertyMapConst.PATENT_TYPE_MAP),saveRequest.getType()));
        BeanUtils.setProperty(patent,"state",getValue(getUnmodifiableMap(PropertyMapConst.PATENT_STATE_MAP),saveRequest.getState()));
        BeanUtils.setProperty(patent,"author",author);
        BeanUtils.setProperty(patent,"createTime",new Date());
        BeanUtils.setProperty(patent,"editTime",new Date());
        return patent;
    }
}
