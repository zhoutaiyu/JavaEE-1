package cn.qdgxy.ssmp.exception;

/**
 * 系统自定义的异常类型，实际开发中可能要定义多种异常类型
 * create:2016-10-30 20:31
 *
 * @author 李欣
 * @version 1.0
 */
public class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

}
