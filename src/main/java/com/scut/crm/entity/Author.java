package com.scut.crm.entity;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 编号
	 */
	private String serialNumber;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 专利列表
	 */
	private Set<Patent> patentSet;
	/**
	 * 用户ID
	 */
	private User user;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date editTime;

	public Author(Integer id){
		this.id = id;
	}

	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", name='" + name + '\'' +
				", serialNumber='" + serialNumber + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", userId=" + user.getId() +
				", createTime=" + createTime +
				", editTime=" + editTime +
				'}';
	}
}
