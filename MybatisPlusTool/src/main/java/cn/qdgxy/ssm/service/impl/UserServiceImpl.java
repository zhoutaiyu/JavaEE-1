package cn.qdgxy.ssm.service.impl;

import cn.qdgxy.ssm.mapper.UserMapper;
import cn.qdgxy.ssm.po.User;
import cn.qdgxy.ssm.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liXin
 * @since 2016-12-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
