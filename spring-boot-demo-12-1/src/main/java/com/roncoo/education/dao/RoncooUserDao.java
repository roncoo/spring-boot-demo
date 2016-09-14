/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.education.dao;

import com.roncoo.education.bean.RoncooUser;

/**
 * @author wujing
 */
public interface RoncooUserDao {

	/**
	 * 插入
	 * 
	 * @param roncooUser
	 * @return
	 */
	int insert(RoncooUser roncooUser);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(int id);

	/**
	 * 更新
	 * 
	 * @param roncooUser
	 * @return
	 */
	int updateById(RoncooUser roncooUser);

	/**
	 * 查找
	 * 
	 * @param id
	 * @return
	 */
	RoncooUser selectById(int id);

}
