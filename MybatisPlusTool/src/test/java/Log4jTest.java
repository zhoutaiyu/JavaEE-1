import org.apache.log4j.Logger;

/**
 * Log4j测试
 * create:2016-12-06 16:35
 *
 * @author 李欣
 * @version 1.0
 */
public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        try {
            Class.forName("ErrorClassName");
        } catch (ClassNotFoundException e) {
            logger.debug(e.getMessage(), e);//详细日报信息
            logger.info(e.getMessage(), e);//详细日报信息
            logger.warn(e.getMessage());//简单日报信息
            logger.error(e.getMessage());//简单日报信息
        }

    }
}