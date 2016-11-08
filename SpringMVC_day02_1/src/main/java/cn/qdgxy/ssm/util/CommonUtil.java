package cn.qdgxy.ssm.util;

import java.util.UUID;

/**
 * 小小工具
 *
 * @author 李欣
 * @version 2016-10-15 19:36
 */
public class CommonUtil {

    /**
     * 返回一个32位大写不重复字符串
     *
     * @return 4C349CB238DE465CB96F989559A05A3B
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

}
