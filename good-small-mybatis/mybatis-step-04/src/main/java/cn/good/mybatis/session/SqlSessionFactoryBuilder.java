package cn.good.mybatis.session;

import cn.good.mybatis.builder.xml.XMLConfigBuilder;
import cn.good.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * TODO
 *
 * @Description 构建SqlSessionFactory工厂
 * @Author wkm
 * @Date 2024/12/20
 **/
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(Reader reader){
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }
    public SqlSessionFactory build(Configuration config){
        return new DefaultSqlSessionFactory(config);
    }
}
