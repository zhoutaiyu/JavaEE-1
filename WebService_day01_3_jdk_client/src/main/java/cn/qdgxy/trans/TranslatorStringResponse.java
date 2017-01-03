
package cn.qdgxy.trans;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type的 Java 类。
 * <p>
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TranslatorStringResult" type="{http://WebXml.com.cn/}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "translatorStringResult"
})
@XmlRootElement(name = "TranslatorStringResponse")
public class TranslatorStringResponse {

    @XmlElement(name = "TranslatorStringResult")
    protected ArrayOfString translatorStringResult;

    /**
     * 获取translatorStringResult属性的值。
     *
     * @return possible object is
     * {@link ArrayOfString }
     */
    public ArrayOfString getTranslatorStringResult() {
        return translatorStringResult;
    }

    /**
     * 设置translatorStringResult属性的值。
     *
     * @param value allowed object is
     *              {@link ArrayOfString }
     */
    public void setTranslatorStringResult(ArrayOfString value) {
        this.translatorStringResult = value;
    }

}
