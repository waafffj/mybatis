package cn.good.mybatis.test.java.kang.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/15
 **/
@AllArgsConstructor
@Data
public class Person implements Cloneable{
    public Address address;

    @Override
    protected Person clone() throws CloneNotSupportedException {
      // 浅拷贝  return (Person) super.clone();
        /**
         * 深拷贝
         */
        Person person = (Person) super.clone();
        person.setAddress(person.getAddress().clone());
        return person;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person(new Address("武汉"));
        Person clone = person1.clone();
        System.out.println(person1.getAddress() == clone.getAddress());
    }
}
