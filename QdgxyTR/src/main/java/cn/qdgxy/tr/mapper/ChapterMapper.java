package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.Chapter;

public interface ChapterMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}