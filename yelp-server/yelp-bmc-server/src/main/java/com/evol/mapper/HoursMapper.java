package com.evol.mapper;

import com.evol.domain.model.Hours;
import com.evol.domain.model.HoursExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HoursMapper {
    long countByExample(HoursExample example);

    int deleteByExample(HoursExample example);

    int deleteByPrimaryKey(String id);

    int insert(Hours record);

    int insertSelective(Hours record);

    List<Hours> selectByExample(HoursExample example);

    Hours selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Hours record, @Param("example") HoursExample example);

    int updateByExample(@Param("record") Hours record, @Param("example") HoursExample example);

    int updateByPrimaryKeySelective(Hours record);

    int updateByPrimaryKey(Hours record);
}