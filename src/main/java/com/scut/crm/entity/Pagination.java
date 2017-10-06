package com.scut.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination<T> {
    /**
     * 总记录数
     */
    private int totalRecords;
    /**
     * 当前第几页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPages;
    /**
     * 每一页记录数
     */
    private int pageSize;
    /**
     * 要展示的列表数据
     */
    private List<T> dataList;
    /**
     * 构造方法
     */
    public Pagination(int totalRecords, int currentPage, int pageSize, List<T> dataList) {
        this.totalRecords = totalRecords;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.dataList = dataList;
        this.init();
    }

    /**
     * 初始化
     */
    public void init(){
        if(totalRecords % pageSize == 0){
            this.totalPages = totalRecords / pageSize;
        }else{
            this.totalPages = totalRecords / pageSize + 1;
        }
    }

    /**
     * 第一页
     */
    public int getFirst(){
        return 1;
    }
    /**
     * 上一页
     */
    public int getPrevious(){
        if(currentPage-1 > 0){
            return currentPage - 1;
        }else{
            return 1;
        }
    }
    /**
     * 下一页
     */
    public int getNext(){
        if(currentPage+1 <= totalPages){
            return currentPage + 1;
        }else{
            return totalPages;
        }
    }
    /**
     * 最后一页
     */
    public int getLast(){
        return totalPages;
    }

}
