package cn.good.mybatis.test.java.itlaoqi.thread;

import java.util.Random;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/20
 **/

/**
 * Synchronize的使用场景
 * 1.synchronized代码块 指向任意对象
 * 2.synchronized方法 指向this当前对象
 * 3.synchronized静态方法(方法属于类，使用类名调用)，指向该类的字节码对象
 *
 *
 * 请写出线程安全不安全的类
 *
 * Vector是线程安全的，ArrayList、LinkedList是线程不安全的
 * Properties是线程安全的，HashSet、TreeSet是不安全的
 * StringBuffer是线程安全的、StringBuilder是线程不安全的
 * HashTable是线程安全的，HashMap是线程不安全的
 */
public class SyncSample {
    public static void main(String[] args) {
        Couplet c = new Couplet();
        for(int i = 0;i < 10000;i ++ ){
            new Thread(){
                public void run(){
                    int r = new Random().nextInt(2);
                    if(r % 2 == 0) c.first();
                    else  c.second();
                }
            }.start();
        }
    }
}
class Couplet{
    Object lock = new Object(); // 锁对象
    public synchronized void first(){
        //synchronized (lock){  // 同步代码块，在同一时间只允许有一个访问这个方法
            System.out.println("琴瑟琵琶");
       // }
    }
    public void second(){
        synchronized (this){
            System.out.println("魑魅魍魉");
        }
    }
    /*
    public static void second(){
        synchronized (Couplet.class){
            System.out.println("魑魅魍魉");
        }
    }
    */
}