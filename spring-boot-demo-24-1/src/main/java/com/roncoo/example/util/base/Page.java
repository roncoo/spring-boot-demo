/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.example.util.base;

import java.io.Serializable;
import java.util.List;

/**
 * 数据分页组件
 * 
 * @author wujing
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = -5764853545343945831L;

	/**
	 * 默认每页记录数(20)
	 */
	public static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 最大每页记录数(1000)
	 */
	public static final int MAX_PAGE_SIZE = 1000;

	/**
	 * 当前分页的数据集
	 */
	private List<T> list;

	/**
	 * 总记录数
	 */
	private int totalCount;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 当前页
	 */
	private int pageCurrent;

	/**
	 * 每页记录数
	 */
	private int pageSize;

	/**
	 * 排序字段
	 */
	private String orderField;

	/**
	 * 排序方式：asc or desc
	 */
	private String orderDirection;

	/**
	 * 默认构造函数
	 */
	public Page() {
	}

	/**
	 * 构造函数
	 * 
	 * @param totalCount
	 *            总记录数
	 * @param totalPage
	 *            总页数
	 * @param pageCurrent
	 * @param pageSize
	 * @param list
	 */
	public Page(int totalCount, int totalPage, int pageCurrent, int pageSize, List<T> list) {
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

}
