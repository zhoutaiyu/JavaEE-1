package cn.qdgxy.tr.mapper;

import cn.qdgxy.tr.po.Subject;

public interface SubjectMapper {

    int deleteByPrimaryKey(Integer sid);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}