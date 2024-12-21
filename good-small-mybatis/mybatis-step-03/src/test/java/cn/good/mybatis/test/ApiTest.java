package cn.good.mybatis.test;

import cn.good.mybatis.io.Resources;
import cn.good.mybatis.session.SqlSession;
import cn.good.mybatis.session.SqlSessionFactory;
import cn.good.mybatis.session.SqlSessionFactoryBuilder;
import cn.good.mybatis.test.dao.IUserDao;
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
       Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
       SqlSession sqlSession = sqlSessionFactory.openSession();

       IUserDao userDao = sqlSession.getMapper(IUserDao.class);
       String res = userDao.queryUserInfoById("10001");
       logger.info("测试结果 : {}",res);
   }
}
