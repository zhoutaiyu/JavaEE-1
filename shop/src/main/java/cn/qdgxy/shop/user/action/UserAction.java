package cn.qdgxy.shop.user.action;

import cn.qdgxy.shop.user.service.UserService;
import cn.qdgxy.shop.user.vo.User;
import cn.qdgxy.shop.user.vo.UserException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private static final long serialVersionUID = 1L;
    private User user = new User();
    @Resource
    private UserService userService;

    private String verifyCode; // 验证码

    private String msg; // 提示信息

    /**
     * 跳转至登录页面
     */
    @InputConfig(resultName = "loginInput")
    public String loginPage() {
        return "loginPage";
    }

    /**
     * 跳转至注册页面
     *
     * @return String
     */
    public String registPage() {
        return "registPage";
    }

    /**
     * 登录
     *
     * @return String
     */
    @InputConfig(resultName = "loginInput")
    public String login() {
        // 校验验证码
        String _verifyCode = (String) ActionContext.getContext().getSession().get("verifyCode");
        if (!_verifyCode.equalsIgnoreCase(verifyCode)) {
            msg = "验证码错误！";
            return "loginInput";
        }

        try {
            User _user = userService.login(user);

            // 登陆成功
            ActionContext.getContext().getSession().put("user", _user);
            return "login_success";
        } catch (UserException e) {
            // 登录失败
            msg = e.getMessage();
            return "loginInput";
        }
    }

    /**
     * 退出
     *
     * @return String
     */
    public String exit() {
        ServletActionContext.getRequest().getSession().invalidate();
        return "exit_success";
    }

    /**
     * 注册
     *
     * @return String
     */
    @InputConfig(resultName = "registInput")
    public String regist() {
        // 校验验证码
        String _verifyCode = (String) ActionContext.getContext().getSession().get("verifyCode");
        if (!_verifyCode.equalsIgnoreCase(verifyCode)) {
            msg = "验证码错误！";
            return "registInput";
        }

        try {
            userService.regist(user);

            // 注册成功
            msg = "注册成功！请去邮箱激活账户！";
            return "msgPage";
        } catch (UserException e) {
            // 注册失败
            msg = e.getMessage();
            return "registInput";
        }
    }

    /**
     * 激活
     *
     * @return String
     */
    public String active() {
        try {
            userService.active(user.getCode());
            msg = "激活成功！";
        } catch (UserException e) {
            msg = e.getMessage();
        }

        return "msgPage";
    }

    /**
     * Ajax：检验用户名是否存在
     *
     * @return String
     * @throws IOException IO异常
     */
    public String checkUsername() throws IOException {
        User _user = userService.findByUsername(user.getUsername());

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html; charset=UTF-8");

        if (_user != null) {
            // 用户存在
            response.getWriter().print("exist");
        } else {
            // 用户不存在
            response.getWriter().print("notexist");
        }

        return NONE;
    }

    @Override
    public User getModel() {
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getMsg() {
        return msg;
    }

}
