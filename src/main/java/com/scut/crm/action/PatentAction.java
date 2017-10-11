package com.scut.crm.action;

import com.scut.crm.constant.PageReturnConst;
import com.scut.crm.entity.Author;
import com.scut.crm.entity.Patent;
import com.scut.crm.entity.Pagination;
import com.scut.crm.service.impl.PatentServiceImpl;
import com.scut.crm.service.impl.AuthorServiceImpl;
import com.scut.crm.utils.ScopeUtils;
import com.scut.crm.utils.convert.PatentConvertUtils;
import com.scut.crm.web.vo.save.PatentSaveRequest;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Data
@Scope("prototype")
@Controller
@Log4j
public class PatentAction {

    private PatentSaveRequest saveRequest;

    private String authorId;

    private String patentId;

    private String currentPage;

    private String deleteJson;

    @Autowired
    private PatentServiceImpl patentService;

    @Autowired
    private AuthorServiceImpl authorService;

    /**
     * 专利添加
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public String add() throws InvocationTargetException, IllegalAccessException {
        log.info("patentAction----saveRequest"+saveRequest);
        /**获取author*/
        Author author = authorService.getBySerialNumber(saveRequest.getAuthor_serialNumber());

        /**重点：逻辑判断被绕过，若同时两个线程进入创建了两个相同的Identifier，则会产生线程安全问题，要加锁确保线程安全*/
        /**用消息队列来做是否可行？*/
        synchronized(this){
            /**获取patent的serialNumber*/
            String patentSerialNumber = patentService.getIdentifier(Patent.class);
            Patent patent = PatentConvertUtils.fromSaveRequest2Patent(saveRequest, patentSerialNumber, author);
            log.info(patent);
            patentService.save(patent);
        }
        return PageReturnConst.ADD_SUCCESS;
    }

    /**
     * 合同详细
     * @return
     */
    public String check(){
        Map<String,Object> map = new HashMap<>();
        map.put("currentPage",currentPage);
        map.put("authorId",authorId);
        Pagination<Patent> pagination = patentService.listByForeignKey(map);
        ScopeUtils.getRequestMap().put("authorId", authorId);
        ScopeUtils.getRequestMap().put("pagination", pagination);
        return PageReturnConst.CHECK_SUCCESS;
    }

    /**
     * 合同列表
     * @return
     */
    public String list(){
        Map<String,Object> map = new HashMap<>();
        map.put("currentPage",currentPage);
        Pagination<Patent> pagination = patentService.listByPage(map);
        ScopeUtils.getRequestMap().put("pagination",pagination);
        return PageReturnConst.PATENT_INDEX;
    }

    /**
     * 合同删除
     * @return
     */
    public String delete(){
        patentService.remove(new Patent(Integer.valueOf(patentId)));
        deleteJson = PageReturnConst.DELETE_SUCCESS;
        return deleteJson;
    }
}
