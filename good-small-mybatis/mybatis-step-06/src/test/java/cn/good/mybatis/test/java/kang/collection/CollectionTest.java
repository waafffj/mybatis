package cn.good.mybatis.test.java.kang.collection;

/**
 * TODO
 *
 * @Description Collection接口 和 Map 接口
 * @Author wkm
 * @Date 2025/1/22
 **/


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合框架
 *  Collection接口 单列接口，用来存储一个一个的对象
 *   List接口: 存储有序的、可重复的数据  --> 动态数组
 *      ---- ArrayList 作为List接口主要实现类 线程不安全，效率高 底层使用Object[] elementData存储
 *           LinkedList 对于频繁的插入、删除操作，使用效率高，底层使用双向链表存储
 *           Vector 线程安全     使用protected Object[] elementData存储;
 *
 *   Set接口: 存储无序的、不可重复的数据
 *      ----- HashSet、LinkedHashSet、TreeSet
 *
 *   Map接口 key,value
 *      ----- HashMap、LinkedHashMap、TreeMap、HashTable、Properties
 *
 *  Collection接口中的方法
 *
 *  内部的方法 hasNext() 和 next()
 *  集合对象每次调用iterator方法都得到一个全新的迭代器对象，默认游标在0
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add("A");
        collection.add("B");
        collection.add("A");
        // size() 获取添加的元素的个数
        System.out.println(collection.size());

        // addAll() 将另一个集合中的元素添加到当前集合
        Collection coll1 = new ArrayList();
        coll1.add("CC");
        coll1.add("C");
        collection.addAll(coll1);
        System.out.println(collection.size());
        System.out.println(collection);
        // clear 清空集合元素
        //collection.clear();
        // isEmpty 判断当前集合是否为空
  //      System.out.println(collection.isEmpty());

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
