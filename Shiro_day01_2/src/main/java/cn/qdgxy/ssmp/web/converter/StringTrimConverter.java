package cn.qdgxy.ssmp.web.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 字符串去除前后空格转换器
 *
 * @author 李欣
 * @version 1.0
 * @since 2016-12-23 10:53
 */
public class StringTrimConverter implements Converter<String, String> {

    @Override
    public String convert(String source) {
        try {
            //去掉字符串两边空格，如果去除后为空设置为null
            if (source != null) {
                source = source.trim();
                if (source.equals("")) {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return source;
    }

}
