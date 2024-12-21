package cn.good.mybatis.session;

import cn.good.mybatis.binding.MapperRegistry;
import cn.good.mybatis.datasource.druid.DruidDataSourceFactory;
import cn.good.mybatis.mapping.Environment;
import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.transaction.jdbc.JdbcTransactionFactory;
import cn.good.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Description 配置项
 * @Author wkm
 * @Date 2024/12/20
 **/
public class Configuration {
    protected Environment environment;
    /** 映射注册机*/
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);
    /** 映射的语句，存在Map里*/
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();
    /** 类型别名注册机*/
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
