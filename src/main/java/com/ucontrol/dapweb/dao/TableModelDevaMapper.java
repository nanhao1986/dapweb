package com.ucontrol.dapweb.dao;

import com.ucontrol.dapweb.entity.TableModelDeva;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

public interface TableModelDevaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TableModelDeva record);

    int insertSelective(TableModelDeva record);

    TableModelDeva selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TableModelDeva record);

    int updateByPrimaryKey(TableModelDeva record);

    ArrayList<TableModelDeva> selectAll();

    ArrayList<TableModelDeva> selectByLevel(int level);

    ArrayList<TableModelDeva> selectByParent(@Param("level")int level, @Param("parentIndex")int parent_index);

}