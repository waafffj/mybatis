package cn.good.mybatis.test;

import cn.good.mybatis.test.dao.IActivityDao;
import cn.good.mybatis.test.dao.IUserDao;
import cn.good.mybatis.test.po.Activity;
import cn.good.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2024/12/14
 **/
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_SqlSessionFactory() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        Activity req = new Activity();
        req.setActivityId(100001L);

        SqlSession sqlSession01 = sqlSessionFactory.openSession();
        IActivityDao dao01 = sqlSession01.getMapper(IActivityDao.class);
        logger.info("测试结果01: {}", JSON.toJSONString(dao01.queryActivityById(req)));
        sqlSession01.close();

        SqlSession sqlSession02 = sqlSessionFactory.openSession();
        IActivityDao dao02 = sqlSession02.getMapper(IActivityDao.class);
        logger.info("测试结果02: {}", JSON.toJSONString(dao02.queryActivityById(req)));
        sqlSession02.close();
    }
    @Test
    public void test_SqlSessionFactory_Annotation() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource-annotation.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.queryUserInfoList();
        logger.info("测试结果: {}",JSON.toJSONString(users));

    }
}
