package cn.qdgxy.shop.user.dao;

import cn.qdgxy.shop.user.vo.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    /**
     * 保存用户
     *
     * @param user
     */
    public void save(User user) {
        hibernateTemplate.save(user);
    }

    /**
     * 修改用户信息
     *
     * @param user
     */
    public void update(User user) {
        hibernateTemplate.update(user);
    }

    /**
     * 按用户名查找用户
     *
     * @param username
     * @return
     */
    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        List<User> users = (List<User>) hibernateTemplate.find(
                "from User where username=?", username);

        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 按Email查找用户
     *
     * @param email
     * @return
     */
    @SuppressWarnings("unchecked")
    public User findByEmail(String email) {
        List<User> users = (List<User>) hibernateTemplate.find(
                "from User where email=?", email);

        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 按照激活码查询用户
     *
     * @param code
     * @return
     */
    @SuppressWarnings("unchecked")
    public User findByCode(String code) {
        List<User> users = (List<User>) hibernateTemplate.find(
                "from User where code=?", code);

        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

}
