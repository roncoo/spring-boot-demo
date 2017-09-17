/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.example.util.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * sql工具类
 * 
 * @author wujing
 */
public class Sql {
	private Sql() {
	}

	/**
	 * 检测sql，防止sql注入
	 * 
	 * @param sql
	 *            sql
	 * @return 正常返回sql；异常返回""
	 */
	public static String checkSql(String sql) {
		String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
		String inj_stra[] = inj_str.split("\\|");
		for (int i = 0; i < inj_stra.length; i++) {
			if (sql.indexOf(inj_stra[i]) >= 0) {
				return "";
			}
		}
		return sql;
	}

	/**
	 * 计算总页数
	 *
	 * @param totalCount
	 *            总记录数.
	 * @param pageSize
	 *            每页记录数.
	 * @return totalPage 总页数.
	 */
	public static int countTotalPage(final int totalCount, final int pageSize) {
		if (totalCount % pageSize == 0) {
			return totalCount / pageSize; // 刚好整除
		} else {
			return totalCount / pageSize + 1; // 不能整除则总页数为：商 + 1
		}
	}

	/**
	 * 校验当前页数pageCurrent<br/>
	 * 1、先根据总记录数totalCount和每页记录数pageSize，计算出总页数totalPage<br/>
	 * 2、判断页面提交过来的当前页数pageCurrent是否大于总页数totalPage，大于则返回totalPage<br/>
	 * 3、判断pageCurrent是否小于1，小于则返回1<br/>
	 * 4、其它则直接返回pageCurrent
	 *
	 * @param totalCount
	 *            要分页的总记录数
	 * @param pageSize
	 *            每页记录数大小
	 * @param pageCurrent
	 *            输入的当前页数
	 * @return pageCurrent
	 */
	public static int checkPageCurrent(int totalCount, int pageSize, int pageCurrent) {
		int totalPage = countTotalPage(totalCount, pageSize); // 最大页数
		if (pageCurrent > totalPage) {
			// 如果页面提交过来的页数大于总页数，则将当前页设为总页数
			// 此时要求totalPage要大于获等于1
			if (totalPage < 1) {
				return 1;
			}
			return totalPage;
		} else if (pageCurrent < 1) {
			return 1; // 当前页不能小于1（避免页面输入不正确值）
		} else {
			return pageCurrent;
		}
	}

	/**
	 * 校验页面输入的每页记录数pageSize是否合法<br/>
	 * 1、当页面输入的每页记录数pageSize大于允许的最大每页记录数MAX_PAGE_SIZE时，返回MAX_PAGE_SIZE
	 * 2、如果pageSize小于1，则返回默认的每页记录数DEFAULT_PAGE_SIZE
	 *
	 * @param pageSize
	 *            页面输入的每页记录数
	 * @return checkPageSize
	 */
	public static int checkPageSize(int pageSize) {
		if (pageSize > Page.MAX_PAGE_SIZE) {
			return Page.MAX_PAGE_SIZE;
		} else if (pageSize < 1) {
			return Page.DEFAULT_PAGE_SIZE;
		} else {
			return pageSize;
		}
	}

	/**
	 * 计算当前分页的开始记录的索引
	 *
	 * @param pageCurrent
	 *            当前第几页
	 * @param pageSize
	 *            每页记录数
	 * @return 当前页开始记录号
	 */
	public static int countOffset(final int pageCurrent, final int pageSize) {
		return (pageCurrent - 1) * pageSize;
	}

	/**
	 * 根据总记录数，对页面传来的分页参数进行校验，并返分页的SQL语句
	 *
	 * @param pageCurrent
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @param pageBean
	 *            DWZ分页查询参数
	 * @return limitSql
	 */
	public static String limitSql(int totalCount, int pageCurrent, int pageSize) {
		// 校验当前页数
		pageCurrent = checkPageCurrent(totalCount, pageSize, pageCurrent);
		pageSize = checkPageSize(pageSize); // 校验每页记录数
		return " limit " + countOffset(pageCurrent, pageSize) + "," + pageSize;
	}

	/**
	 * 根据分页查询的SQL语句，获取统计总记录数的语句
	 *
	 * @param sql
	 *            分页查询的SQL
	 * @return countSql
	 */
	public static String countSql(String sql) {
		String countSql = sql.substring(sql.toLowerCase().indexOf("from")); // 去除第一个from前的内容
		return "select count(*) " + removeOrderBy(countSql);
	}

	/**
	 * 移除SQL语句中的的order by子句（用于分页前获取总记录数，不需要排序）
	 *
	 * @param sql
	 *            原始SQL
	 * @return 去除order by子句后的内容
	 */
	private static String removeOrderBy(String sql) {
		Pattern pat = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher mc = pat.matcher(sql);
		StringBuffer strBuf = new StringBuffer();
		while (mc.find()) {
			mc.appendReplacement(strBuf, "");
		}
		mc.appendTail(strBuf);
		return strBuf.toString();
	}
}
