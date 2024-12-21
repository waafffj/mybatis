package cn.good.mybatis.test;

import cn.good.mybatis.binding.MapperRegistry;
import cn.good.mybatis.session.SqlSession;
import cn.good.mybatis.session.SqlSessionFactory;
import cn.good.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.good.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
   public void test_MapperProxyFactory(){
    MapperRegistry mapperRegistry = new MapperRegistry();
    mapperRegistry.addMappers("cn.good.mybatis.test.dao");
    /* 从sqlSession 工厂获取session*/
    SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    String res = userDao.queryUserName("10001");
    logger.info("测试结果 :{} ",res);
   }
}
