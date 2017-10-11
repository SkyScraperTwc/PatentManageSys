package com.scut.crm.entity;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
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
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 手机
	 */
	private String phone;
	/**
	 * 客户列表
	 */
	private Set<Author> authorSet;
	/**
	 * 专利文件
	 */
	private Set<FileBean> fileBeanSet;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date editTime;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", phone='" + phone + '\'' +
				", createTime=" + createTime +
				", editTime=" + editTime +
				'}';
	}
}