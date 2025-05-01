package cn.good.mybatis.reflection.wrapper;

import cn.good.mybatis.reflection.MetaObject;

/**
 * TODO
 *
 * @Description 对象包装工厂
 * @Author wkm
 * @Date 2025/1/5
 **/
public interface ObjectWrapperFactory {
    /* 判断有没有包装器 */
    boolean hasWrapperFor(Object object);
    /* 得到包装器*/
    ObjectWrapper getWrapperFor(MetaObject metaObject,Object object);
}
