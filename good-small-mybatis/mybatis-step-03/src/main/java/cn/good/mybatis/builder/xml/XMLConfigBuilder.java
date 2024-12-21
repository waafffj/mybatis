package cn.good.mybatis.builder.xml;

import cn.good.mybatis.builder.BaseBuilder;
import cn.good.mybatis.io.Resources;
import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.mapping.SqlCommandType;
import cn.good.mybatis.session.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @Description XML配置构建器,建造者模式,继承BaseBuilder
 * @Author wkm
 * @Date 2024/12/20
 **/
public class XMLConfigBuilder extends BaseBuilder {
    /** 用于存储XML文件的根元素*/
    private Element root;
    public XMLConfigBuilder(Reader reader){
        /** 调用父类初始化Configuration*/
        super(new Configuration());
        /** dom4j 处理xml 用于解析XML */
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new InputSource(reader));
            /** 将XML文档的根元素赋值给root变量 */
            root = document.getRootElement();
        }catch (DocumentException e){
            e.printStackTrace();
        }
    }
    /** 解析配置: 类型别名、插件、对象工厂、对象包装工厂、设置、环境、类型转换、映射器*/
    public Configuration parse(){
        try {
            /** 解析映射器*/
            mapperElement(root.element("mappers"));
        }catch (Exception e){
            throw new RuntimeException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
        return configuration;
    }


    private void mapperElement(Element mappers) throws Exception {
        /** 获取所有的mapper元素 */
        List<Element> mapperList = mappers.elements("mapper");
        /** 遍历所有的mapper元素*/
        for(Element e : mapperList){
            /** 获取mapper的资源路径 */
            String resource = e.attributeValue("resource");
            /** 根据资源路径获取Reader对象 */
            Reader reader = Resources.getResourceAsReader(resource);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new InputSource(reader));
            Element root = document.getRootElement();
            /** 命名空间*/
            String namespace = root.attributeValue("namespace");
            List<Element> selectNodes = root.elements("select");
            for(Element node : selectNodes){
                String id = node.attributeValue("id");
                String parameterType = node.attributeValue("parameterType");
                String resultType = node.attributeValue("resultType");
                String sql = node.getText();

                /** 匹配*/
                Map<Integer,String> parameter = new HashMap<>();
                Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                Matcher matcher = pattern.matcher(sql);
                for(int i = 1;matcher.find();i ++ ){
                    String g1 = matcher.group(1);
                    String g2 = matcher.group(2);
                    parameter.put(i,g2);
                    sql = sql.replace(g1,"?");
                }

                String msId = namespace + "." + id;
                String nodeName = node.getName();
                SqlCommandType sqlCommandType = SqlCommandType.valueOf(nodeName.toUpperCase(Locale.ENGLISH));
                MappedStatement mappedStatement = new MappedStatement.Builder(configuration,msId,sqlCommandType,parameterType,resultType,sql,parameter).build();

                /** 添加解析SQL*/
                configuration.addMappedStatement(mappedStatement);
            }
            /** 注册Mapper映射器*/
            configuration.addMapper(Resources.classForName(namespace));
        }
    }
}
