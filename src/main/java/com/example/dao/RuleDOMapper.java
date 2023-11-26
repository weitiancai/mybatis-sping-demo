package com.example.dao;

import com.example.model.RuleDO;
import com.example.model.RuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuleDOMapper {
    long countByExample(RuleDOExample example);

    int deleteByExample(RuleDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RuleDO row);

    int insertSelective(RuleDO row);

    List<RuleDO> selectByExample(RuleDOExample example);

    RuleDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") RuleDO row, @Param("example") RuleDOExample example);

    int updateByExample(@Param("row") RuleDO row, @Param("example") RuleDOExample example);

    int updateByPrimaryKeySelective(RuleDO row);

    int updateByPrimaryKey(RuleDO row);
}