package Spring.IOC;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wzh
 * @time: 2020/7/8 11:54
 * @description:
 */
public class SimpleIOC {
    private Map<String, Object> beanMap = new HashMap<>();

    public SimpleIOC(String location) throws Exception {
        loadBeans(location);
    }

    public Object getBean(String name){
        Object bean = beanMap.get(name);
        if (bean==null)
            throw new IllegalArgumentException("没有此对象"+name);
        return bean;
    }
    private void loadBeans(String location) throws Exception{
        //加载xml配置文件
        InputStream inputStream = new FileInputStream(location);
        //DocumentBuilderFactory：处理xml文档的类
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();

        //遍历 bean 标签
        for (int i=0;i<nodes.getLength();i++){
            Node node = nodes.item(i);
            if (node instanceof Element){
                Element ele = (Element)node;

                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");
                //加载beanClass
                Class beanClass = null;
                try {
                    //动态加载类,参数为类的全限定名
                    beanClass = Class.forName(className);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                    return;
                }
                //创建bean，使用newInstance方法来新建Object
                Object bean = beanClass.newInstance();
                //遍历 property 标签
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j=0;j<propertyNodes.getLength();j++){
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element){
                        Element propertyElement = (Element)propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");
                        //利用反射将bean字段权限设置为可访问
                        //Field是字段，getDeclaredField是获取某个字段（可以是私有字段）
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        //设置为true之后，就可以设置私有字段
                        declaredField.setAccessible(true);

                        if (value!=null && value.length()>0){
                            //利用反射为私有字段设置值
                            declaredField.set(bean, value);
                        }else {
                            //property中是一个ref，引用了新的对象
                            String ref = propertyElement.getAttribute("ref");
                            if (ref==null || ref.length()==0){
                                throw new IllegalArgumentException("ref config error");
                            }
                            //将引用填充到相关字段
                            declaredField.set(bean, getBean(ref));
                        }
                        //注册bean到bean容器中
                        registerBean(id, bean);
                    }
                }
            }
        }
    }
    private void registerBean(String id, Object bean){
        beanMap.put(id, bean);
    }
}
