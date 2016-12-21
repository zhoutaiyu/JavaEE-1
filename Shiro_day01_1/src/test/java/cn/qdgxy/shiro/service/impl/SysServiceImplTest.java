package cn.qdgxy.shiro.service.impl;

import cn.qdgxy.shiro.po.SysUser;
import cn.qdgxy.shiro.service.SysService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 *
 * @author 李欣
 * @version ${VERSION}
 * @since 2016-12-21 20:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})
public class SysServiceImplTest {

    @Resource
    private SysService sysService;

    @Test
    public void authenticat() throws Exception {

    }

    @Test
    public void findSysUserByUserCode() throws Exception {
        SysUser sysUser = sysService.findSysUserByUserCode("10000");
        System.out.println(sysUser);
    }

    @Test
    public void findMenuListByUserId() throws Exception {

    }

    @Test
    public void findPermissionListByUserId() throws Exception {

    }

}