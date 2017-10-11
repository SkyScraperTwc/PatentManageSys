package com.scut.crm.action;

import com.scut.crm.constant.EntityNumberConst;
import com.scut.crm.constant.FilePropertyConst;
import com.scut.crm.constant.PageReturnConst;
import com.scut.crm.entity.FileBean;
import com.scut.crm.entity.Pagination;
import com.scut.crm.entity.User;
import com.scut.crm.service.impl.FileHandleService;
import com.scut.crm.utils.ScopeUtils;
import com.scut.crm.web.vo.query.FileShareRequest;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Scope("prototype")
@Controller
@Log4j
public class FileHandleAction{

    private File uploadFile;

    private String uploadFileFileName;

    private String downloadFileName;

    private String searchContent;

    private String currentPage;

    private FileShareRequest fileShareRequest;

    @Autowired
    private FileHandleService fileHandleService;

    /**
     * 登录页面
     */
    public String toSearch() throws Exception {
        return PageReturnConst.TOSEARCH;
    }
    /**
     * 文件列表
     * @return
     */
    public String list(){
        Map<String,Object> map = new HashMap<>();
        map.put("currentPage",currentPage);
        Pagination<FileBean> pagination = fileHandleService.listByPage(map);
        ScopeUtils.getRequestMap().put("pagination",pagination);
        return PageReturnConst.FILE_INDEX;
    }

    public String search(){
        Map<String,Object> map = new HashMap<>();
        map.put("currentPage",currentPage);
        map.put("searchContent",searchContent);
        Pagination<FileBean> pagination = fileHandleService.searchFiles(map);
        ScopeUtils.getRequestMap().put("pagination",pagination);
        return PageReturnConst.SEARCH_SUCCESS;
    }


    public String download(){
        return PageReturnConst.DOWNLOAD_SUCCESS;
    }

    /**
     * 下载源
     */
    public InputStream getInputStream() {
        User user = (User) ScopeUtils.getSessionMap().get("user");
        String downloadPath = FilePropertyConst.BASE_SAVE_PATH+File.separator+user.getUsername();
        File downloadFile = new File(downloadPath, downloadFileName);
        try {
            return FileUtils.openInputStream(downloadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载文件名称
     */
    public String getDownloadFileName(){
        try {
            downloadFileName= URLEncoder.encode(downloadFileName, "UTF-8");//解决下载中文命名文件乱码问题
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return downloadFileName;
    }

    public String upload(){
        User user = (User) ScopeUtils.getSessionMap().get("user");
        String savePath = FilePropertyConst.BASE_SAVE_PATH+File.separator+user.getUsername();
        File storeFile = new File(savePath,uploadFileFileName);
        /**上传文件的大小,单位字节*/
        long size = this.uploadFile.length();
        String message = checkFile(storeFile, size);
        if (!message.equals("checkIsOk")){
            ScopeUtils.getRequestMap().put("message", message);
            return PageReturnConst.UPLOAD_ERROR;
        }

        //todo 检查用户的云空间是否超过限额
        /**验证全部通过，把文件复制到本地硬盘的用户的目录下*/
        try {
            /**上传文件到本地硬盘*/
            FileUtils.copyFile(uploadFile, storeFile);   //上传文件到本地硬盘
            FileBean fileBean = new FileBean(null, uploadFileFileName, savePath, (int)(size/FilePropertyConst.FACTOR_MB_TO_KBYTE+1), false, user, new Date(), new Date());
            fileHandleService.save(fileBean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PageReturnConst.UPLOAD_SUCCESS;
    }

    private String checkFile(File store, long size){
        String message = "";
        if(store.exists()){
            message = "文件已经存在";
        }else if(size== Integer.valueOf(EntityNumberConst.ZERO)){
            message = "文件大小不能为0";
        }else if(size > FilePropertyConst.LIMIT_SIZE){
            message = "用户最大只能上传"+FilePropertyConst.LIMIT_SIZE/FilePropertyConst.FACTOR_MB_TO_BYTE+"Mb的文件";
        }else{
            message = "checkIsOk";
        }
        return message;
    }

    public String changeShare(){
        fileHandleService.changeFileShareStatus(fileShareRequest);
        return PageReturnConst.UPDATE_SUCCESS;
    }
}

