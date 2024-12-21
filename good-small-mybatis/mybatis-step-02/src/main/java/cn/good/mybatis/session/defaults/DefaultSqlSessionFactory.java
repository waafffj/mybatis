package cn.good.mybatis.session.defaults;

import cn.good.mybatis.binding.MapperRegistry;
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
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
