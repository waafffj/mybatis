package cn.good.mybatis.test.java.kang.String;

import org.junit.Test;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/15
 **/
public class StringBufferBuilderTest {
    /**
     *
     * String StringBuffer StringBuilder三者的异同
     * String 不可变的字符序列 底层使用char[]存储 jdk9以前， 9以后使用byte
     * StringBuffer 可变的字符序列 线程安全的，效率低 底层使用char[]存储 jdk9以前， 9以后使用byte
     * StringBuilder 可变的字符序列 jdk5.0新增,线程不安全，效率高 底层使用char[]存储 jdk9以前， 9以后使用byte
     *
     *
     * 源码分析
     *  String str = new String(); // char[] value = new char[0];
     *  String str1 = new String("abc"); // char[] value = new char[]{'a','b','c'};
     *  StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16] 底层创建了一个长度为16的数组
     *  StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length() + 16] 底层创建了一个长度为 length + 16的数组
     *  如果添加数据底层数组盛不下，那就需要扩容底层的数组
     *  默认情况下,扩容为原来容量的2倍 + 2,同时将原有数组中的元素复制到新的数组中\
     *
     *
     *
     *
     *
     *
     *   StringBuffer与 build 方法
     *  StringBuffer append(xxx):提供了很多的append()方法，用于进行字符串拼接
     *  StringBuffer delete(int start,int end):删除指定位置的内容 左闭右开
     *  StringBuffer replace(int start,int end,string str):把[start,end)位置替换为str
     *  StringBuffer insert(int offset,xxx):在指定位置插入xxx
     *  StringBuffer reverse():把当前字符序列逆转
     *  public int indexOf(string str)
     *  public String substring(int start,int end)
     *  public int length()
     *  public char charAt(int n)
     *  public void setCharAt(int n,char ch)
     */
   /* @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
    }*/
    @Test
    public void test(){
        String[] arr = {"he","llo"};
        String s = "";
        for(int i = 0;i < arr.length;i ++ ){
            s += arr[i];
        }
        System.out.println(s);

    }
}
