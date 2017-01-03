
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
 *         &lt;element name="TranslatorResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "translatorResult"
})
@XmlRootElement(name = "TranslatorResponse")
public class TranslatorResponse {

    @XmlElement(name = "TranslatorResult")
    protected TranslatorResult translatorResult;

    /**
     * 获取translatorResult属性的值。
     *
     * @return possible object is
     * {@link TranslatorResult }
     */
    public TranslatorResult getTranslatorResult() {
        return translatorResult;
    }

    /**
     * 设置translatorResult属性的值。
     *
     * @param value allowed object is
     *              {@link TranslatorResult }
     */
    public void setTranslatorResult(TranslatorResult value) {
        this.translatorResult = value;
    }


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
     *         &lt;any/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "any"
    })
    public static class TranslatorResult {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * 获取any属性的值。
         *
         * @return possible object is
         * {@link Object }
         */
        public Object getAny() {
            return any;
        }

        /**
         * 设置any属性的值。
         *
         * @param value allowed object is
         *              {@link Object }
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
