/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.education.bean;

import java.util.Date;

/**
 * 实体类
 * 
 * @author wujing
 */
public class RoncooUserLog {
	private int id;
	private String desc;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "RoncooUserLog [id=" + id + ", desc=" + desc + ", createTime=" + createTime + "]";
	}

}
