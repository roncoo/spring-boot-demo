package com.roncoo.education.mapper;

import com.roncoo.education.bean.RoncooUserLog;
import com.roncoo.education.bean.RoncooUserLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoncooUserLogMapper {
    int countByExample(RoncooUserLogExample example);

    int deleteByExample(RoncooUserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoncooUserLog record);

    int insertSelective(RoncooUserLog record);

    List<RoncooUserLog> selectByExample(RoncooUserLogExample example);

    RoncooUserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoncooUserLog record, @Param("example") RoncooUserLogExample example);

    int updateByExample(@Param("record") RoncooUserLog record, @Param("example") RoncooUserLogExample example);

    int updateByPrimaryKeySelective(RoncooUserLog record);

    int updateByPrimaryKey(RoncooUserLog record);
}