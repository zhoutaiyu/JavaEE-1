package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.RecordItem;

public interface RecordItemMapper {

    int insert(RecordItem record);

    int insertSelective(RecordItem record);
}