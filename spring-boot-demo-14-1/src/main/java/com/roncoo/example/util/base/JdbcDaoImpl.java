/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.example.util.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

/**
 * spirng jdbc 基本支撑类
 * 
 * @author wujing
 */
public abstract class JdbcDaoImpl {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/**
	 * 获取当前事务最后一次更新的主键值
	 */
	public Long getLastId() {
		return jdbcTemplate.queryForObject("select last_insert_id() as id", Long.class);
	}

	/**
	 * 获取对象信息
	 */
	public <T> T queryForObject(String sql, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(clazz), args);
	}

	/**
	 * 获取对象集合信息
	 */
	public <T> List<T> queryForObjectList(String sql, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}

	/**
	 * 分页，jdbcTemplate 不支持like自定义，只能拼装
	 */
	public Page<Map<String, Object>> queryForPage(String sql, int pageCurrent, int pageSize, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1");
		String sqlCount = Sql.countSql(sql);
		int count = jdbcTemplate.queryForObject(sqlCount, Integer.class, args);
		pageCurrent = Sql.checkPageCurrent(count, pageSize, pageCurrent);
		pageSize = Sql.checkPageSize(pageSize);
		int totalPage = Sql.countTotalPage(count, pageSize);
		String sqlList = sql + Sql.limitSql(count, pageCurrent, pageSize);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlList, args);
		return new Page<Map<String, Object>>(count, totalPage, pageCurrent, pageSize, list);
	}

	/**
	 * 分页，jdbcTemplate 不支持like是定义，只能拼装
	 */
	public <T> Page<T> queryForPage(String sql, int pageCurrent, int pageSize, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1");
		Assert.isTrue(clazz != null, "clazz 不能为空");
		String sqlCount = Sql.countSql(sql);
		int count = jdbcTemplate.queryForObject(sqlCount, Integer.class, args);
		pageCurrent = Sql.checkPageCurrent(count, pageSize, pageCurrent);
		pageSize = Sql.checkPageSize(pageSize);
		int totalPage = Sql.countTotalPage(count, pageSize);
		String sqlList = sql + Sql.limitSql(count, pageCurrent, pageSize);
		List<T> list = jdbcTemplate.query(sqlList, new BeanPropertyRowMapper<T>(clazz), args);
		return new Page<T>(count, totalPage, pageCurrent, pageSize, list);
	}

}
