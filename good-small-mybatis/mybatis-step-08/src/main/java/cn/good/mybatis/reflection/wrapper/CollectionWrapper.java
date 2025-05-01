package cn.good.mybatis.reflection.wrapper;

import cn.good.mybatis.reflection.MetaObject;
import cn.good.mybatis.reflection.factory.ObjectFactory;
import cn.good.mybatis.reflection.property.PropertyTokenizer;

import java.util.Collection;
import java.util.List;

/**
 * TODO
 *
 * @Description Collection 包装器
 * @Author wkm
 * @Date 2025/4/27
 **/
public class CollectionWrapper implements ObjectWrapper{
 // 原来的对象
 private Collection<Object> object;

 public CollectionWrapper(MetaObject metaObject, Collection<Object> object) {
  this.object = object;
 }

 // get,set都是不允许的,只能添加元素 集合不支持按属性名(get/set)访问
 @Override
 public Object get(PropertyTokenizer prop) {
  throw new UnsupportedOperationException();
 }

 @Override
 public void set(PropertyTokenizer prop, Object value) {
  throw new UnsupportedOperationException();
 }

 @Override
 public String findProperty(String name, boolean useCamelCaseMapping) {
  throw new UnsupportedOperationException();
 }

 @Override
 public String[] getGetterNames() {
  throw new UnsupportedOperationException();
 }

 @Override
 public String[] getSetterNames() {
  throw new UnsupportedOperationException();
 }

 @Override
 public Class<?> getSetterType(String name) {
  throw new UnsupportedOperationException();
 }

 @Override
 public Class<?> getGetterType(String name) {
  throw new UnsupportedOperationException();
 }

 @Override
 public boolean hasSetter(String name) {
  throw new UnsupportedOperationException();
 }

 @Override
 public boolean hasGetter(String name) {
  throw new UnsupportedOperationException();
 }

 @Override
 public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
  throw new UnsupportedOperationException();
 }

 @Override
 public boolean isCollection() {
  return true;
 }

 @Override
 public void add(Object element) {
  object.add(element);
 }

 @Override
 public <E> void addAll(List<E> element) {
  object.addAll(element);
 }

}
