package cn.qdgxy.mybatis.dao;

import cn.qdgxy.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 用户Dao实现
 * create:2016-10-16 17:46
 *
 * @author 李欣
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {

    // 将sqlSessionFactory注入
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        //创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByName(String username) throws Exception {
        //创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserByName", "小明");
        sqlSession.close();
        return users;
    }

    @Override
    public void insertUser(User user) throws Exception {
        //创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

}
