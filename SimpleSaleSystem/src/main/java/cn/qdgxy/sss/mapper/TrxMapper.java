package cn.qdgxy.sss.mapper;

import cn.qdgxy.sss.po.Trx;
import cn.qdgxy.sss.po.TrxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrxMapper {

    long countByExample(TrxExample example);

    int deleteByExample(TrxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Trx record);

    int insertSelective(Trx record);

    List<Trx> selectByExample(TrxExample example);

    Trx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Trx record, @Param("example") TrxExample example);

    int updateByExample(@Param("record") Trx record, @Param("example") TrxExample example);

    int updateByPrimaryKeySelective(Trx record);

    int updateByPrimaryKey(Trx record);
}