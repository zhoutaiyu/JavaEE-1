package cn.qdgxy.shop.utils.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理存入服务器时间与获取时间
 *
 * @author 李欣
 */
public class TimeUtils {

    /**
     * 获得当前时间
     *
     * @return 2016-08-23 21:41:43:160
     */
    public static String getNowTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                .format(new Date());
    }

    /**
     * 得到网页显示时间
     *
     * @param time 数据库存放时间
     * @return 2016-08-23 21:41:43
     */
    public static String getNormalTime(String time) {
        return time.substring(0, time.lastIndexOf(':'));
    }

    /**
     * 将数据库中存放的时间转换成日期对象
     *
     * @param time 数据库中存放的时间
     * @return
     */
    @Deprecated
    public static Date convertDate(String time) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
