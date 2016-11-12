package cn.qdgxy.freemarket;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试FreeMarker
 * create:2016-11-12 16:16
 *
 * @author 李欣
 * @version 1.0
 */
public class FreeMarketTest {

    private Configuration cfg = null;

    @Before
    public void init() throws Exception {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File("F:\\Source\\Java\\JavaEE\\FreeMarker\\src\\main\\webapp\\WEB-INF\\freemarker"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    @Test
    public void test() throws Exception {
        // 获得模板
        Template ftl = cfg.getTemplate("user.ftl");

        // 数据
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("name", "zhansgan");
        root.put("password", "12345");

        // 输出
        Writer out = new OutputStreamWriter(System.out);
        ftl.process(root, out);
    }

}

















