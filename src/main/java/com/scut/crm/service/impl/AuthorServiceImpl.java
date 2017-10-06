package com.scut.crm.service.impl;

import com.scut.crm.constant.PaginationPropertyConst;
import com.scut.crm.dao.impl.BaseDaoImpl;
import com.scut.crm.entity.Author;
import com.scut.crm.entity.Pagination;
import com.scut.crm.entity.User;
import com.scut.crm.service.AbstractBaseService;
import com.scut.crm.utils.ScopeUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Log4j
public class AuthorServiceImpl extends AbstractBaseService<Author> {

	@Autowired
	private BaseDaoImpl baseDao;

	@Override
	public Pagination<Author> listByPage(Map<String,Object> map) {
		String hql = "select author from Author author where 1=1";
		StringBuffer joint = new StringBuffer("");
		List<Object> paramList = new ArrayList<>();

		Author author = null;
		String currentPage = "";
		String authorName = "";
		String authorSerialNumber = "";
		String authorPhone = "";
		if(null!=map && map.size()>0){
			author = (Author) map.get("author");
			currentPage =  (String) map.get("currentPage");
			authorName = author.getName();
			authorSerialNumber = author.getSerialNumber();
			authorPhone = author.getPhone();
		}

		User user = (User) ScopeUtils.getSessionMap().get("user");
		String userId = String.valueOf(user.getId());
		if(null!=userId && !userId.isEmpty()){
			joint.append(" and author.user.id=?");
			paramList.add(Integer.valueOf(userId));
		}
		if(null==currentPage || currentPage.isEmpty()){
			/**currentPage=1*/
			currentPage = String.valueOf(PaginationPropertyConst.PAGE_CURRENT_ONE);
		}
		if(null!=authorName && !authorName.isEmpty()){
			joint.append(" and author.name=?");
			paramList.add(authorName);
		}
		if(null!=authorSerialNumber && !authorSerialNumber.isEmpty()){
			joint.append(" and author.serialNumber=?");
			paramList.add(authorSerialNumber);
		}
		if(null!=authorPhone && !authorPhone.isEmpty()){
			joint.append(" and author.phone=?");
			paramList.add(authorPhone);
		}
		hql = hql + joint.toString();

		/**获取totalRecords*/
		int totalRecords = this.getTotalRecords(joint.toString(), paramList.toArray());

		/**查询authorList*/
		List<Author> authorList = baseDao.queryByPage(hql, paramList.toArray(), Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN);

		/**构建pagination*/
		Pagination<Author> pagination = new Pagination<>(totalRecords, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN, authorList);
		log.info("Pagination<author>---hql----"+hql);
		log.info("Pagination<author>---paramList----"+paramList);
		log.info("Pagination<author>---pagination----"+pagination);
		return pagination;
	}

	/**
	 * 根据外键userId查询
	 * @param map
	 * @return
	 */
	@Override
	public Pagination<Author> listByForeignKey(Map<String,Object> map) {
		String hql = "select author from Author author where 1=1";
		List<Object> paramList = new ArrayList<>();
		StringBuffer joint = new StringBuffer("");

		String currentPage = (String) map.get("currentPage");
		String userId = (String) map.get("userId");
		if(null==currentPage || currentPage.isEmpty()){
			/**currentPage=1*/
			currentPage = String.valueOf(PaginationPropertyConst.PAGE_CURRENT_ONE);
		}
		if(null!=userId && !userId.isEmpty()){
			joint.append(" and author.user.id=?");
			paramList.add(userId);
		}
		int totalRecords = this.getTotalRecords(joint.toString(), paramList.toArray());
		List<Author> dataList = baseDao.queryByPage(hql, paramList.toArray(), Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN);
		Pagination<Author> pagination = new Pagination<>(totalRecords, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN, dataList);
		return pagination;
	}


	@Override
	public int getTotalRecords(String joint, Object[] params) {
		String hql = "select count(*) from Author author where 1=1";
		hql = hql + joint;
		int totalRecords = baseDao.count(hql, params);
		log.info("getTotalRecords----hql---"+hql);
		log.info("getTotalRecords----totalRecords----"+totalRecords);
		return totalRecords;
	}

	@Override
	public Author getById(Integer id) {
		return (Author) baseDao.get(Author.class, id);
	}

	@Override
	public Author getBySerialNumber(String serialNumber) {
		String hql = "select author from Author author where author.serialNumber=?";
		List<Object> paramList = new ArrayList<>();
		paramList.add(serialNumber);
		Author author = (Author) baseDao.queryOne(hql,paramList.toArray());
		return author;
	}

}
