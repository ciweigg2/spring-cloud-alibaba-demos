package com.ciwei.common.config;

import com.google.common.collect.Lists;
import com.nepxion.banner.BannerConstant;
import com.nepxion.banner.Description;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * 输出版本信息
 */
public class AlibabaInfos {

    public static final List<Description> descriptions = Lists.newArrayList();

    public static void getAlibabaInfos() {
        descriptions.add(new Description(BannerConstant.VERSION + ":", "0.1", 0, 1));
        descriptions.add(new Description("technology:", "Spring Cloud Alibaba", 0, 1));
        descriptions.add(new Description("introduce:", "总有起风的清晨\uD83C\uDF2A 总有绚烂的黄昏\uD83C\uDF0C 总有总有流星的夜晚\uD83C\uDF20", 0, 1));
        String path = new File("").getAbsolutePath();
        try {
            File file = new File(path + File.separator + "pom.xml");
            SAXReader reader = new SAXReader();
            Document document = null;
            try {
                document = reader.read(new File(file.getAbsolutePath()));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            Element root = document.getRootElement();
            listNodes(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取每个pom文件中的version标签以及里面的内容
     */
    public static void listNodes(Element node) {
        if (node.getName().equals("parent")) {
            Iterator<Element> iterator = node.elementIterator();
            while (iterator.hasNext()) {
                node = iterator.next();
                if (node.getName().equals("version")) {
                    descriptions.add(new Description("spring-boot-starter-parent.version", node.getText(), 0, 1));
                }
            }
        }
        if (node.getName().equals("properties")) {
            Iterator<Element> iterator = node.elementIterator();
            while (iterator.hasNext()) {
                node = iterator.next();
                descriptions.add(new Description(node.getName(), node.getText(), 0, 1));
            }
        }
        Iterator<Element> iterator = node.elementIterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            listNodes(e);
        }
    }

}
