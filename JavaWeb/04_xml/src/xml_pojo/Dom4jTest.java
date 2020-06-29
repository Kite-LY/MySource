package xml_pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {

    @Test
    public void test01() throws Exception {
        //创建一个SaxReader输入流，去读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        //生成document对象
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }


    @Test
    public void test02() throws DocumentException {
        //1.读取books.xml文件
        SAXReader reader = new SAXReader();
        //2.通过Document对象获取根元素
        Document document = reader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        //3.通过根元素获取book标签对象
        List<Element> books = rootElement.elements();
        //4.遍历，处理灭个book标签对象转换为book类
        for (Element book : books) {
            //asXML():把标签对象，转换为标签字符
            //System.out.println(book.asXML());

            //获取标签中的内容
            String nameText = book.elementText("name");
            String authorText = book.elementText("author");
            String priceText = book.elementText("price");
            String sn = book.attributeValue("sn");
            System.out.println(new Book(sn,nameText,Double.parseDouble(priceText),authorText));
        }
    }
}
