package cn.qdgxy.mybatis.po;

import java.util.List;

/**
 * pojo包装对象，将来在使用时从页面传到Controller、Service、Mapper<br>
 * create:2016-10-17 8:32
 *
 * @author 李欣
 * @version 1.0
 */
public class UserQueryVo {

    // 用户信息
    private User user;

    // 自定义User扩展类型
    private UserCustom userCustom;

    // id集合
    private List<Integer> ids;

    public UserQueryVo() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

}
