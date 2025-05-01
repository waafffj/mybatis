package cn.good.mybatis.test.java.kang.clone;

import lombok.AllArgsConstructor;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/15
 **/
@AllArgsConstructor
public class Address implements Cloneable{
 private String name;
 @Override
 protected Address clone() throws CloneNotSupportedException {
  return (Address) super.clone();
 }
}
