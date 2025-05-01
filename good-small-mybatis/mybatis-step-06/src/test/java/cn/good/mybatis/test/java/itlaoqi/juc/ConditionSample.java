package cn.good.mybatis.test.java.itlaoqi.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @Description JAVA多线程与并发编程
 * @Author wkm
 * @Date 2025/1/20
 **/

/**
 * 程序是静态的概念，windows下通常是指exe文件
 * 进程是动态的概念，是程序在运行状态，进程说明程序在内存中的边界
 * 线程是进程内的一个"基本任务",每个线程都有自己的功能，是CPU分配和调度的基本单位
 */
public class ConditionSample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(); // Condition对象必须配合Lock一起使用
        Condition c1 = lock.newCondition(); // 创建Condition
        Condition c2 = lock.newCondition(); // 创建Condition
        Condition c3 = lock.newCondition(); // 创建Condition
        new Thread(new Runnable(){
            @Override
            public void run(){
                lock.lock(); // 加锁
                try {
                    c1.await();
                    Thread.sleep(1000);
                    System.out.println(4);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                lock.lock(); // 加锁
                try {
                    c2.await();
                    Thread.sleep(1000);
                    System.out.println(3);
                    c1.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                lock.lock(); // 加锁
                try {
                    c3.await();
                    Thread.sleep(1000);
                    System.out.println(2);
                    c2.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                lock.lock(); // 加锁
                try {
                    Thread.sleep(1000);
                    System.out.println(1);
                    c3.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

    }
}
