package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.Chapter;

public interface ChapterMapper {

    int deleteByPrimaryKey(Integer cid);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}