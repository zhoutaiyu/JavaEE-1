package cn.qdgxy.sss.dao.impl;

import cn.qdgxy.sss.dao.PersonDao;
import cn.qdgxy.sss.mapper.PersonMapper;
import cn.qdgxy.sss.po.Person;
import cn.qdgxy.sss.po.PersonCustom;
import cn.qdgxy.sss.po.PersonExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Dao实现
 * create:2016-11-13 20:56
 *
 * @author 李欣
 * @version 1.0
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    @Resource
    private PersonMapper personMapper;

    /**
     * 按用户名查找用户
     *
     * @param userName 用户名
     * @return 用户
     */
    @Override
    public PersonCustom findByUsername(String userName) throws Exception {
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();
        criteria.andUsernameEqualTo(userName);

        List<Person> persons = personMapper.selectByExample(personExample);
        if (persons == null || persons.isEmpty()) {
            return null;
        }

        PersonCustom personCustom = new PersonCustom();
        BeanUtils.copyProperties(persons.get(0), personCustom);
        return personCustom;
    }
}
