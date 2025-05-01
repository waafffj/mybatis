package cn.good.mybatis.reflection;

import cn.good.mybatis.reflection.factory.DefaultObjectFactory;
import cn.good.mybatis.reflection.factory.ObjectFactory;
import cn.good.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import cn.good.mybatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * TODO
 *
 * @Description 一些系统级别的元对象
 * @Author wkm
 * @Date 2025/1/4
 **/
public class SystemMetaObject {
    public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    public static final MetaObject NULL_META_OBJECT = MetaObject.forObject(NullObject.class, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);

    private SystemMetaObject() {
    }
    private static class NullObject{
    }
    public static MetaObject forObject(Object object){
        return MetaObject.forObject(object,DEFAULT_OBJECT_FACTORY,DEFAULT_OBJECT_WRAPPER_FACTORY);
    }
}