package cn.itcast.user.service;

/**
 * 自定义一个异常类 只是给出父类中的构造器即可！方便用来创建对象！
 * 
 * @author li119
 *
 */
public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserException() {
		super();
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

}
