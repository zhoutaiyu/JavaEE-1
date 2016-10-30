package cn.qdgxy.ssm.mapper;

import cn.qdgxy.ssm.po.CategorySecond;
import cn.qdgxy.ssm.po.CategorySecondExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategorySecondMapper {
    long countByExample(CategorySecondExample example);

    int deleteByExample(CategorySecondExample example);

    int deleteByPrimaryKey(Integer csid);

    int insert(CategorySecond record);

    int insertSelective(CategorySecond record);

    List<CategorySecond> selectByExample(CategorySecondExample example);

    CategorySecond selectByPrimaryKey(Integer csid);

    int updateByExampleSelective(@Param("record") CategorySecond record, @Param("example") CategorySecondExample example);

    int updateByExample(@Param("record") CategorySecond record, @Param("example") CategorySecondExample example);

    int updateByPrimaryKeySelective(CategorySecond record);

    int updateByPrimaryKey(CategorySecond record);
}