package cn.good.mybatis.session.defaults;

import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.session.SqlSession;
import cn.good.mybatis.session.SqlSessionFactory;

/**
 * TODO
 *
 * @Description 默认的DefaultSqlSessionFactory
 * @Author wkm
 * @Date 2024/12/17
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
