package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.Record;

public interface RecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}