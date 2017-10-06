package com.scut.crm.entity;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patent {
    /**
     * id
     */
    private Integer id;
    /**
     * 编号
     */
    private String serialNumber;
    /**
     * 专利名字
     */
    private String name;
    /**
     * 专利类型
     */
    private String type;//1发明专利 2实用新型专利 3外观设计专利
    /**
     * 专利状态
     */
    private String state;//1专利申请尚未授权 2专利申请撤回 3专利权有效
    /**
     * 作者
     */
    private Author author;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date editTime;

    public Patent(Integer id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                ", authorId=" + author.getId() +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                '}';
    }
}
