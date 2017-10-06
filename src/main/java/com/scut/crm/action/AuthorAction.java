package com.scut.crm.action;

import com.alibaba.fastjson.JSON;
import com.scut.crm.constant.PageReturnConst;
import com.scut.crm.entity.Author;
import com.scut.crm.entity.Pagination;
import com.scut.crm.entity.User;
import com.scut.crm.service.impl.AuthorServiceImpl;
import com.scut.crm.utils.convert.AuthorConvertUtils;
import com.scut.crm.utils.ScopeUtils;
import com.scut.crm.web.vo.query.AuthorQueryRequest;
import com.scut.crm.web.vo.save.AuthorSaveRequest;
import com.scut.crm.web.vo.update.AuthorUpdateRequest;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Data
@Scope("prototype")
@Controller
@Log4j
public class AuthorAction {

	private String authorId;

	private String detailJson;

	private String deleteJson;

	private String updateJson;

	private AuthorQueryRequest queryRequest;

	private AuthorSaveRequest saveRequest;

	private AuthorUpdateRequest updateRequest;

	@Autowired
	private AuthorServiceImpl authorService;

	/**
	 * 客户列表
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public String list() throws InvocationTargetException, IllegalAccessException {
		/**queryRequest转换成author*/
		Map<String,Object> map = AuthorConvertUtils.fromQueryRequest2Author(queryRequest);
		Pagination<Author> pagination = authorService.listByPage(map);
		ScopeUtils.getRequestMap().put("pagination",pagination);
		return PageReturnConst.AUTHOR_INDEX;
	}

	/**
	 * 客户添加
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public String add() throws InvocationTargetException, IllegalAccessException {
		String serialNumber = authorService.getIdentifier(Author.class);
		User user = (User) ScopeUtils.getSessionMap().get("user");
		/**saveRequest转换成author*/
		Author author = AuthorConvertUtils.fromSaveRequest2Author(saveRequest, serialNumber, user);
		authorService.save(author);
		return PageReturnConst.ADD_SUCCESS;
	}

	/**
	 * 客户删除
	 * @return
	 */
	public String delete(){
		authorService.remove(new Author(Integer.valueOf(authorId)));
		deleteJson = PageReturnConst.DELETE_SUCCESS;
		return deleteJson;
	}

	/**
	 * 客户更新
	 * @return
	 */
	public String update() throws InvocationTargetException, IllegalAccessException {
		User user = (User) ScopeUtils.getSessionMap().get("user");
		Author author = AuthorConvertUtils.fromUpdateRequest2Author(updateRequest, user);
		authorService.update(author);
		updateJson = PageReturnConst.UPDATE_SUCCESS;
		return updateJson;
	}

	/**
	 * 客户详细信息
	 * @return
	 */
	public String detail() throws InvocationTargetException, IllegalAccessException {
		Author author = authorService.getById(Integer.valueOf(authorId));
		AuthorUpdateRequest updateRequest = AuthorConvertUtils.fromAuthor2UpdateRequest(author);
		/**转换为json格式*/
		detailJson = JSON.toJSONString(updateRequest);
		return PageReturnConst.DETAIL_SUCCESS;
	}
}
