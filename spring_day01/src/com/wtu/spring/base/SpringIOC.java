package com.wtu.spring.base;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SpringIOC {

    private String xmlPath;

    public SpringIOC(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String id) throws Exception {
        //解析spring.xml文件  得到Document对象
        Document document = this.getDocument(xmlPath);
        //根据 bean的id 获得bean元素
        Element beanElement = this.getBeanElement(document, id);
        //获取bean元素的class属性值
        String classAttributeValue = this.getAttributeValue(beanElement);
        //根据class属性值通过反射创建对象
        Object obj = this.getObject(classAttributeValue);
        //获取bean下property元素的name属性值和value属性  并且赋值给obj
        obj = this.setProperty(obj, beanElement);

        return obj;
    }


    /**
     * 获取property元素  然后得到name 和 value的值 赋值给obj对象
     *
     * @param obj
     * @param beanElement
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private Object setProperty(Object obj, Element beanElement) throws Exception {
        List<Element> elementList = beanElement.elements("property");
        for (Element element : elementList) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            // 通过beanUtils来给对象赋值
            BeanUtils.setProperty(obj, name, value);
        }
        return obj;
    }

    /**
     * 根据字符串 通过反射创建对象
     *
     * @param classAttributeValue
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private Object getObject(String classAttributeValue) throws Exception {

        return Class.forName(classAttributeValue).newInstance();
    }

    /**
     * 根据bean元素 获取该元素中class属性的属性值
     *
     * @param beanElement
     * @return
     */
    private String getAttributeValue(Element beanElement) {
        String attributeValue = beanElement.attributeValue("class");
        return attributeValue;
    }

    /**
     * 根据bean标签的id属性值  获取到该bean标签对应的元素对象 采用xpath查找
     *
     * @param document
     * @param id
     * @return
     */
    private Element getBeanElement(Document document, String id) {
        //传递xpath路径  然后document根据路径找到该元素
        String xpath = "//bean[@id='" + id + "']";
        Element element = (Element) document.selectSingleNode(xpath);
        return element;
    }

    /**
     * 根据xml文件的路径  解析得到Document对象
     *
     * @param xmlPath
     * @return
     * @throws SAXException
     */
    private Document getDocument(String xmlPath) throws Exception {
        SAXReader read = new SAXReader();
        return read.read(new File(xmlPath));
    }
}
