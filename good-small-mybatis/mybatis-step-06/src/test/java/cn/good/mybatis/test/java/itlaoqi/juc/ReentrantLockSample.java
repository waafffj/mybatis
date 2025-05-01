package cn.good.mybatis.test.java.itlaoqi.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
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
public class ReentrantLockSample {
    public static int users =  100;// 同时模拟的并发访问用户数量
    public static int downTotal = 50000;// 用户下载的真实总数
    public static int count = 0; // 计数器
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(); //调度器,jdk1.5后提供的concurrent包对于并发的支持
        // 信号量,用于模拟并发的人数
        final Semaphore semaphore = new Semaphore(users);
        for(int i = 0;i < downTotal;i ++ ){
            executorService.execute(()->{
                // 通过多线程模拟n个用户并发访问并下载
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown(); // 关闭调度服务
        System.out.println("下载总数 : " + count);
    }
    public static void add(){
        lock.lock();
        try{
            count ++;
        }finally {
            lock.unlock();
        }
    }
}
