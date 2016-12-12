package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.RecordItem;

public interface RecordItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RecordItem record);

    int insertSelective(RecordItem record);

    RecordItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RecordItem record);

    int updateByPrimaryKey(RecordItem record);
}