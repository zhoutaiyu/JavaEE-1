package cn.qdgxy.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义异常处理器
 * create:2016-10-30 20:31
 *
 * @author 李欣
 * @version 1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    /**
     * 前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
     *
     * @param request  request
     * @param response response
     * @param handler  最终要执行的Handler，它的真实身份是HandlerMethod
     * @param ex       接收到的异常信息
     * @return ModelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //输出异常
        ex.printStackTrace();

        //统一异常处理代码
        //针对系统自定义的CustomException异常，就可以直接从异常类中获取异常信息，将异常处理在错误页面展示
        String exceptionMessage;  //异常信息
        CustomException customException;

        if (ex instanceof CustomException) {    //如果ex是系统自定义的异常，直接取出异常信息
            customException = (CustomException) ex;
        } else { //针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”
            customException = new CustomException("未知错误,请联系管理员！");
        }

        //错误 信息
        exceptionMessage = customException.getMessage();

        request.setAttribute("msg", exceptionMessage);


        try {
            //转向到错误页面
            request.getRequestDispatcher("/WEB-INF/jsps/error.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView();
    }

}
