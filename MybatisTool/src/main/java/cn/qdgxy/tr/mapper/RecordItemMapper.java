package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.RecordItem;

public interface RecordItemMapper {

    int deleteByPrimaryKey(Integer riid);

    int insert(RecordItem record);

    int insertSelective(RecordItem record);

    RecordItem selectByPrimaryKey(Integer riid);

    int updateByPrimaryKeySelective(RecordItem record);

    int updateByPrimaryKey(RecordItem record);
}