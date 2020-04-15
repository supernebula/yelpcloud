package com.evol.mapper;

import com.evol.domain.model.Checkin;
import com.evol.domain.model.CheckinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckinMapper {
    long countByExample(CheckinExample example);

    int deleteByExample(CheckinExample example);

    int deleteByPrimaryKey(String id);

    int insert(Checkin record);

    int insertSelective(Checkin record);

    List<Checkin> selectByExample(CheckinExample example);

    Checkin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Checkin record, @Param("example") CheckinExample example);

    int updateByExample(@Param("record") Checkin record, @Param("example") CheckinExample example);

    int updateByPrimaryKeySelective(Checkin record);

    int updateByPrimaryKey(Checkin record);
}