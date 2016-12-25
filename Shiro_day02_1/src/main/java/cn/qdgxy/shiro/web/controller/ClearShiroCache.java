package cn.qdgxy.shiro.web.controller;

import cn.qdgxy.shiro.shiro.CustomRealm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * 手动调用controller清除shiro的缓存
 */
@Controller
public class ClearShiroCache {

    //注入realm
    @Resource
    private CustomRealm customRealm;

    @RequestMapping("/clearShiroCache")
    public String clearShiroCache() {
        //清除缓存，将来正常开发要在service调用customRealm.clearCached()
        customRealm.clearCached();
        return "success";
    }

}
