package com.example.dao;

import com.example.model.MenuDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuDO row);

    int insertSelective(MenuDO row);

    MenuDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuDO row);

    int updateByPrimaryKey(MenuDO row);
}