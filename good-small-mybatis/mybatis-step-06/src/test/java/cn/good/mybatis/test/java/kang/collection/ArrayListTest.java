package cn.good.mybatis.test.java.kang.collection;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/22
 **/
public class ArrayListTest {
    /**
     * ArrayList的源码分析:
     * jdk 7情况下
     * ArrayList list = new ArrayList() 底层创建了长度为10的Object[]数组elementData
     * list.add(3);// elementData[0] = new Integer(123);
     *
     * list.add(11); // 如果此次的添加导致底层elementData数组容量不足，则扩容
     * 默认情况下，扩容为原来的1.5倍，同时需要将原有数组中的数据复制到新的数组中
     *
     * jdk 8中ArrayList的变化:
     * ArrayList list = new ArrayList(); // 底层Object[] elementData初始化为{}.并没有创建长度
     * list.add(1);// 第一次调用add()时，底层才创建了长度10的数组，并将数据添加进去
     *
     * 后续添加和扩容与jdk7相同
     *
     * jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象创建类似于单例的懒汉式，延迟数组的创建，节省内存
     *
     *
     * LinkedList  的源码分析
     * LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性,默认值为null
     * list.add(123);// 将123封装到Node中，创建了Node对象
     * Node体现了LinkedList的双向链表
     *
     *
     *
     * Vector的源码分析：jdk7和8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
     * 在扩容时，默认扩容为原来的2倍
     */

}
