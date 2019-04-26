package com.ucontrol.dapweb.dao;

import com.ucontrol.dapweb.entity.TableModelptDeva;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface TableModelptDevaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TableModelptDeva record);

    int insertSelective(TableModelptDeva record);

    TableModelptDeva selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TableModelptDeva record);

    int updateByPrimaryKey(TableModelptDeva record);

    ArrayList<TableModelptDeva> selectByLevelAndIndex(@Param("modelLevel")int model_level, @Param("modelIndex")int model_index);
}