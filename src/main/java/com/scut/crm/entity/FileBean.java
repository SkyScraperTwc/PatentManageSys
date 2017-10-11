package com.scut.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileBean {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 文件大小
	 */
	private int fileSize;
	/**
	 * 是否共享
	 */
	private boolean canShare;
	/**
	 * 所属用户
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

}
