package cn.itcast.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 日记记录
 * 
 * @author 李欣
 *
 */
public class Log4jTest {

	private Logger logger = Logger.getLogger(Log4jTest.class);

	@Test
	public void demo1() throws Exception {
		logger.fatal("致命错误");
		logger.error("普通错误");
		logger.warn("警告信息");
		logger.info("普通信息");
		logger.debug("调试信息");
		logger.trace("堆栈信息");
	}

}
