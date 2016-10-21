package cn.qdgxy.mybatis.dao;

import cn.qdgxy.mybatis.po.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 整合开发原始dao接口<br>
 * create:2016-10-16 17:46
 *
 * @author 李欣
 * @version 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public UserDaoImpl() {
    }

    public User findUserById(int id) {
        return sqlSessionTemplate.selectOne("cn.qdgxy.mybatis.mapper.UserMapper.findUserById", id);
    }


}
