package cn.qdgxy.mybatis.until.mabatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis逆向工程<br>
 * 数据库账户需要新建，只对应与项目数据库，不是能使用root，否则mapper.xml产生多余sql语句<br>
 * 每次生成前需要将原先的文件删除掉
 * create:2016-10-23 19:57
 *
 * @author 李欣
 * @version 1.0
 */
public class GeneratorSqlmap {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(GeneratorSqlmap.class.getClassLoader().getResourceAsStream("mybatis/generator/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("----ok----");
    }

}
