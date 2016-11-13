package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.dao.PersonDao;
import cn.qdgxy.sss.exception.MyException;
import cn.qdgxy.sss.po.PersonCustom;
import cn.qdgxy.sss.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户Service实现类
 * create:2016-11-12 20:49
 *
 * @author 李欣
 * @version 1.0
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;


    /**
     * 登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户
     * @throws Exception 异常
     */
    @Override
    public PersonCustom login(String userName, String password) throws Exception {
        PersonCustom personCustom = personDao.findByUsername(userName);

        if (personCustom == null) {
            throw new MyException("用户不存在!");
        }

        if (!personCustom.getPassword().equals(password)) {
            throw new MyException("密码错误！");
        }

        return personCustom;
    }
}
