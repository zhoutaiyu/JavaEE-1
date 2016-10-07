package cn.qdgxy.shop.utils.uuid;

import java.util.UUID;

/**
 * 获得UUID
 *
 * @author 李欣
 */
public class UUIDUtils {

    /**
     * 获得UUID
     *
     * @return F64F3010CB49405793BCD750ACCB6692
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

}
