package cn.qdgxy.ssm.controller.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试拦截器1
 * create:2016-10-30 20:51
 * <p>
 * author 李欣
 *
 * @version 1.0
 */
@Controller
public class HandlerInterceptor1 implements HandlerInterceptor {

    /**
     * 在执行handler之前来执行的
     * <p>
     * 用于用户认证校验、用户权限校验
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        System.out.println("HandlerInterceptor1...preHandle");

        //如果返回false表示拦截不继续执行handler，如果返回true表示放行
        return true;
    }


    /**
     * 在执行handler返回modelAndView之前来执行
     * <p>
     * 如果需要向页面提供一些公用 的数据或配置一些视图信息，使用此方法实现 从modelAndView入手
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptor1...postHandle");

    }

    /**
     * 执行handler之后执行此方法
     * <p>
     * 作系统 统一异常处理，进行方法执行性能监控，在preHandle中设置一个时间点，在afterCompletion设置一个时间，两个时间点的差就是执行时长
     * <p>
     * 实现 系统 统一日志记录
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("HandlerInterceptor1...afterCompletion");
    }

}
