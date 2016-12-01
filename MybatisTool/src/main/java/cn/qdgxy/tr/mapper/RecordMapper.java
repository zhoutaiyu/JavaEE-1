package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.Record;

public interface RecordMapper {

    int deleteByPrimaryKey(Integer rid);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}