package cn.good.mybatis.session.defaults;

import cn.good.mybatis.binding.MapperRegistry;
import cn.good.mybatis.session.SqlSession;

/**
 * TODO
 *
 * @Description 默认的SqlSession实现类
 * @Author wkm
 * @Date 2024/12/17
 **/
public class DefaultSqlSession implements SqlSession {
    /* 映射器注册机 */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T)("你被代理了" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T)("你被代理了" + "方法 : " + statement + "入参 : " + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type,this);
    }
}
