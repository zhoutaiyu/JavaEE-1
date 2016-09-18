package cn.itcast.user.exception;

/**
 * 自定义异常
 * 
 * @author 李欣
 *
 */
public class MySQLException extends Exception {

	private static final long serialVersionUID = 1L;

	public MySQLException() {
		super();
	}

	public MySQLException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MySQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public MySQLException(String message) {
		super(message);
	}

	public MySQLException(Throwable cause) {
		super(cause);
	}

}
