package cn.good.mybatis.test.java.kang.collection;

import java.util.HashMap;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/2/7
 **/
public class MapTest {
    /**
     * HashMap的底层实现原理？
     * jdk7 :
     * HashMap map = new HashMap();
     * 在实例化以后，底层创建了长度是16的一维数组Entry[] table
     *  ... 可能已经执行过多次put...
     *  map.put(key1,value1)
     *  首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算之后，得到在Entry数组中的存放位置。
     *  如果此位置上的数据为空，此时的key1-value1添加成功。 ---- 情况1
     *  如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据
     *  的哈希值:
     *          如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功 --- 情况2
     *          如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)
     *                  如果equals()返回false：此时key1-value1添加成功。 --- 情况3
     *                  如果equals()返回true：使用value1替换value2。
     *      补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储
     *      在不断的添加过程中，会涉及到扩容问题，默认的扩容方式为扩容为原来容量的2倍，并将原有的数据复制过来
     *
     *      jdk8相较于jdk7在底层实现方式的不同:
     *      1. new HashMap():底层没有创建一个长度为16的数组
     *      2. jdk8 底层的数组是  Node[],而非Entry[]
     *      3.首次调用put()方法时,底层创建长度为16的数组
     *      4.jdk7底层结构只有:数组+链表。jdk8中底层结构: 数组+链表+红黑树
     *        当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时,
     *        此时此索引位置上的所有数据改为使用红黑树存储
     */

}
