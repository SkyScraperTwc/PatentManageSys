package com.scut.crm.service.impl;

import com.scut.crm.constant.PaginationPropertyConst;
import com.scut.crm.dao.impl.BaseDaoImpl;
import com.scut.crm.entity.FileBean;
import com.scut.crm.entity.Pagination;
import com.scut.crm.entity.User;
import com.scut.crm.service.AbstractBaseService;
import com.scut.crm.utils.ScopeUtils;
import com.scut.crm.web.vo.query.FileShareRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FileHandleService extends AbstractBaseService<FileBean>{

	@Autowired
	private BaseDaoImpl baseDao;

	@Override
	public Pagination<FileBean> listByPage(Map<String, Object> map) {
		String hql = "select fileBean from FileBean fileBean where 1=1";
		StringBuffer joint = new StringBuffer("");
		List<Object> paramList = new ArrayList<>();

		String currentPage = (String) map.get("currentPage");
		User user = (User) ScopeUtils.getSessionMap().get("user");
		String userId = String.valueOf(user.getId());
		if(null!=userId && !userId.isEmpty()){
			joint.append(" and fileBean.user.id=?");
			paramList.add(Integer.valueOf(userId));
		}
		if(null==currentPage || currentPage.isEmpty()){
			/**currentPage=1*/
			currentPage = String.valueOf(PaginationPropertyConst.PAGE_CURRENT_ONE);
		}
		hql = hql + joint;
		/**获取totalRecords*/
		int totalRecords = this.getTotalRecords(joint.toString(), paramList.toArray());
		/**查询patentSet*/
		List<FileBean> dataList = baseDao.queryByPage(hql, paramList.toArray(), Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN);
		/**构建pagination*/
		Pagination<FileBean> pagination = new Pagination<>(totalRecords, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN, dataList);
		return pagination;
	}

	@Override
	public Pagination<FileBean> listByForeignKey(Map<String, Object> map) {
		return null;
	}

	@Override
	public int getTotalRecords(String joint, Object[] params) {
		String hql = "select count(*) from FileBean fileBean where 1=1";
		hql = hql + joint;
		int totalRecords = baseDao.count(hql, params);
		return totalRecords;
	}

	@Override
	public FileBean getById(Integer id) {
		return (FileBean) baseDao.get(FileBean.class,id);
	}

	@Override
	public FileBean getBySerialNumber(String serialNumber) {
		return null;
	}

	/**
	 * 更改文件共享状态
	 * @param fileShareRequest
	 */
	public void changeFileShareStatus(FileShareRequest fileShareRequest){
		String fileId = fileShareRequest.getFileId();
		String canShare = fileShareRequest.getCanShare();
		FileBean fileBean = this.getById(Integer.valueOf(fileId));
		fileBean.setCanShare(Boolean.valueOf(canShare));
		baseDao.update(fileBean);
	}

	/**
	 * 文件搜索
	 * @param map
	 * @return
	 */
    public Pagination<FileBean> searchFiles(Map<String, Object> map) {
		String searchContent = (String) map.get("searchContent");
		String currentPage = (String) map.get("currentPage");
		String hql = "select fileBean from FileBean fileBean where fileBean.canShare=true";
		StringBuffer joint = new StringBuffer("");
		List<Object> paramList = new ArrayList<>();
		if(null!=searchContent && !searchContent.isEmpty()){
			joint.append(" and fileBean.fileName like ?");
			paramList.add("%"+searchContent+"%");
		}
		if(null==currentPage || currentPage.isEmpty()){
			/**currentPage=1*/
			currentPage = String.valueOf(PaginationPropertyConst.PAGE_CURRENT_ONE);
		}
		hql = hql + joint;
		/**获取totalRecords*/
		int totalRecords = this.getTotalRecords(joint.toString(), paramList.toArray());
		/**查询patentSet*/
		List<FileBean> dataList = baseDao.queryByPage(hql, paramList.toArray(), Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN);
		/**构建pagination*/
		Pagination<FileBean> pagination = new Pagination<>(totalRecords, Integer.valueOf(currentPage), PaginationPropertyConst.PAGE_SIZE_TEN, dataList);
		return pagination;
    }
}
