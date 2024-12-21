package cn.good.mybatis.binding;

import cn.good.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @Description 映射器代理工厂
 * @Author wkm
 * @Date 2024/12/14
 **/
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }
    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession,mapperInterface);
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
