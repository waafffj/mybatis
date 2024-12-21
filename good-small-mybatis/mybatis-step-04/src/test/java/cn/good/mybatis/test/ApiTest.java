package cn.good.mybatis.test;

import cn.good.mybatis.builder.xml.XMLConfigBuilder;
import cn.good.mybatis.io.Resources;
import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.session.SqlSession;
import cn.good.mybatis.session.SqlSessionFactory;
import cn.good.mybatis.session.SqlSessionFactoryBuilder;
import cn.good.mybatis.session.defaults.DefaultSqlSession;
import cn.good.mybatis.test.dao.IUserDao;
import cn.good.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2024/12/17
 **/
public class ApiTest {
   private Logger logger = LoggerFactory.getLogger(ApiTest.class);
   @Test
   public void test_MapperProxyFactory() throws IOException {
       /** 从SqlSessionFactory中获取SqlSession */
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
       SqlSession sqlSession = sqlSessionFactory.openSession();


       IUserDao userDao = sqlSession.getMapper(IUserDao.class);
       User user  = userDao.queryUserInfoById(1L);
       logger.info("测试结果 : {}", JSON.toJSONString(user));
   }
    @Test
    public void test_selectOne() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);

        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("cn.good.mybatis.test.dao.IUserDao.queryUserInfoById", req);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}
