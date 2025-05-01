package cn.good.mybatis.session.defaults;

import cn.good.mybatis.executor.Executor;
import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.session.SqlSession;
import java.util.List;

/**
 * TODO
 *
 * @Description 默认的SqlSession实现类
 * @Author wkm
 * @Date 2024/12/17
 **/
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getSqlSource().getBoundSql(parameter));
        return list.get(0);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
