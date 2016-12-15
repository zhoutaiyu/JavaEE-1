package cn.qdgxy.tr.service.impl;

import cn.qdgxy.tr.mapper.UserMapper;
import cn.qdgxy.tr.po.User;
import cn.qdgxy.tr.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户  服务实现类
 * </p>
 *
 * @author liXin
 * @since 2016-12-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
