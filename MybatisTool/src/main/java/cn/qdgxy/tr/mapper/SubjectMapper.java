package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.Subject;

public interface SubjectMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}