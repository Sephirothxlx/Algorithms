package algorithm;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Dom {
	public static void main(String[]args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
           
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("book.xml");
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("一共有" + bookList.getLength() + "本书");
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("=================下面开始遍历第" + (i + 1) + "本书的内容=================");
                Node book = bookList.item(i);
                NamedNodeMap attrs = book.getAttributes();
                System.out.println("第 " + (i + 1) + "本书共有" + attrs.getLength() + "个属性");
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    System.out.print("属性名：" + attr.getNodeName());
                    System.out.println("--属性值" + attr.getNodeValue());
                }
                NodeList childNodes = book.getChildNodes();
                System.out.println("第" + (i+1) + "本书共有" + 
                childNodes.getLength() + "个子节点");
                for (int k = 0; k < childNodes.getLength(); k++) {
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print("第" + (k + 1) + "个节点的节点名：" 
                        + childNodes.item(k).getNodeName());
                        System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
                    }
                }
                System.out.println("======================结束遍历第" + (i + 1) + "本书的内容=================");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}
