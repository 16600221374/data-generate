package util;


import com.encdata.oss.utils.ENCUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.helpers.DefaultHandler;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.sql.SQLOutput;

/**
 * @ClassName: XmlUtil
 * @Author: liuzuncai
 * @Description: xml解析工具类
 * @Date: 2021/1/21 16:56
 * @Version: 1.0
 */
public class XmlUtil {

    //树状解析器
    public static void getXmlInfo() throws Exception{
        //构建解析器对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //<?xml version="1.0" encoding="UTF-8"?>必须放在.xml文件的第一行最开头的位置！且前面不能有空格
        File file = new File("/etc/test.xml");
        Document document = builder.parse(file);
        //获取根节点
        Element root = document.getDocumentElement();
        //获取根节点下的所有节点
        NodeList nodeList = root.getChildNodes();
        //遍历各个节点
        for(int i = 0;i < nodeList.getLength();i++) {
            Node node = nodeList.item(i);
            if(node instanceof Element) {
                Element child = (Element) node;
                if(ENCUtils.isEmpty(child.getFirstChild())) {
                    System.out.println("tag--{}--value--{}"+child.getTagName());
                }
            }
        }
    }

    //流机制解析器
    public static void getXmlInfoStream()  throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        File file = new File("/etc/test.xml");

        DefaultHandler defaultHandler = new DefaultHandler();
        saxParser.parse(file,defaultHandler);
    }

    //生成XML文件
    public static void createXmlFile() {}
}
