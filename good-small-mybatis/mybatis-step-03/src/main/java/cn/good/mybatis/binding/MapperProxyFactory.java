package cn.good.mybatis.binding;

import cn.good.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @Description 映射器代理工厂
 * @Author wkm
 * @Date 2024/12/14
 **/
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;
    private Map<Method,MapperMethod> methodCache = new ConcurrentHashMap<Method,MapperMethod>();

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }
    public Map<Method,MapperMethod> getMethodCache(){
        return methodCache;
    }
    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession,mapperInterface,methodCache);
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
