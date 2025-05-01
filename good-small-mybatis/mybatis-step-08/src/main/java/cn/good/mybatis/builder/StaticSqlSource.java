package cn.good.mybatis.builder;

import cn.good.mybatis.mapping.BoundSql;
import cn.good.mybatis.mapping.ParameterMapping;
import cn.good.mybatis.mapping.SqlSource;
import cn.good.mybatis.session.Configuration;

import java.util.List;

/**
 * TODO
 *
 * @Description 静态SQL源码
 * @Author wkm
 * @Date 2025/5/1
 **/
public class StaticSqlSource implements SqlSource {
    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration,String sql) {
        this(configuration,sql,null);
    }

    public StaticSqlSource( Configuration configuration,String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration,sql,parameterMappings,parameterObject);
    }
}
