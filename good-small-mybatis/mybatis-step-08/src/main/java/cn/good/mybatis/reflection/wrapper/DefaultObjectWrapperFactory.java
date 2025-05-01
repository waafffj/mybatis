package cn.good.mybatis.reflection.wrapper;

import cn.good.mybatis.reflection.MetaObject;

/**
 * TODO
 *
 * @Description 默认对象包装工厂
 * @Author wkm
 * @Date 2025/4/27
 **/
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{
    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
