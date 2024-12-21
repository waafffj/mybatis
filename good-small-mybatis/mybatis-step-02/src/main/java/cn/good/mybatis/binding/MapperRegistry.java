package cn.good.mybatis.binding;

import cn.good.mybatis.session.SqlSession;
import cn.hutool.core.lang.ClassScanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * TODO
 *
 * @Description 映射器注册机
 * @Author wkm
 * @Date 2024/12/17
 **/
public class MapperRegistry {
    /**
     * 将已添加的映射器代理加入到 HashMap
     */
    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();
    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if(mapperProxyFactory == null){
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e){
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> boolean hasMapper(Class<T> type){
        return knownMappers.containsKey(type);
    }

    public <T> void addMapper(Class<T> type){
        /* Mapper 必须是接口才会注册*/
        if(type.isInterface()){
            if(hasMapper(type)){
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            knownMappers.put(type,new MapperProxyFactory<>(type));
        }
    }
    public void addMappers(String packageName){
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for(Class<?> mapperClass : mapperSet){
            addMapper(mapperClass);
        }
    }
}
