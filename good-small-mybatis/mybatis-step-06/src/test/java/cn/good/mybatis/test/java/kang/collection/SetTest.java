package cn.good.mybatis.test.java.kang.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/24
 **/
public class SetTest {
    /**
     * 一、Set: 存储无序的、不可重复的数据
     *
     * LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用
     * 优点:对于频繁的遍历操作方便
     *
     *
     * TreeSet 可根据添加的指定类型排序 自然排序(实现Comparable接口) 定制排序(实现Comparator) 按照参数的方式
     *
     * 自然排序中，比较两个对象是否相同的标准为：compareTo() 返回0。不再是equals()
     * 定制排序中，比较两个对象是否相同的标准为：compare() 返回0。不再是equals()
     *
     */
     // 定制排序
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        TreeSet set = new TreeSet(com);

    }
}
