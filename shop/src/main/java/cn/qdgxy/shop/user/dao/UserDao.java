package cn.qdgxy.shop.user.dao;

import cn.qdgxy.shop.user.vo.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends HibernateDaoSupport {

    /**
     * 保存用户
     *
     * @param user 用户
     */
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    /**
     * 修改用户信息
     *
     * @param user 用户
     */
    public void update(User user) {
        this.getHibernateTemplate().update(user);
    }

    /**
     * 按用户名查找用户
     *
     * @param username 用户名
     * @return 用户
     */
    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        List<User> users = (List<User>) this.getHibernateTemplate().find(
                "from User where username=?", username);

        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 按Email查找用户
     *
     * @param email 用户email
     * @return 用户
     */
    @SuppressWarnings("unchecked")
    public User findByEmail(String email) {
        List<User> users = (List<User>) this.getHibernateTemplate().find(
                "from User where email=?", email);

        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 按照激活码查询用户
     *
     * @param code 激活码
     * @return 用户
     */
    @SuppressWarnings("unchecked")
    public User findByCode(String code) {
        List<User> users = (List<User>) this.getHibernateTemplate().find(
                "from User where code=?", code);

        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

}
