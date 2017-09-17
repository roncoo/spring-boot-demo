package com.roncoo.example.dao;

import com.roncoo.example.bean.RoncooUser;
import com.roncoo.example.util.base.Page;

public interface RoncooUserDao {

	int insert(RoncooUser roncooUser);

	int deleteById(int id);

	int updateById(RoncooUser roncooUser);

	RoncooUser selectById(int id);

	Page<RoncooUser> queryForPage(int i, int j, String string);

}
