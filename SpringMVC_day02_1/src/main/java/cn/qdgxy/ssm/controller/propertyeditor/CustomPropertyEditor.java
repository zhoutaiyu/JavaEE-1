package cn.qdgxy.ssm.controller.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义属性编辑器
 * create:2016-11-05 20:22
 *
 * @author 李欣
 * @version 1.0
 */
public class CustomPropertyEditor implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        // Date.class必须是与controller方法形参pojo属性一致的date类型，这里是java.util.Date
        propertyEditorRegistry.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

}
