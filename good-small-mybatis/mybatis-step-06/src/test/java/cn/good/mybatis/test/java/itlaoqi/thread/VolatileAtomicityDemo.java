package cn.good.mybatis.test.java.itlaoqi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/4/2
 **/
public class VolatileAtomicityDemo {
    public volatile static int inc = 0;

    Lock lock = new ReentrantLock();
    public  void incr(){
        lock.lock();
        try{
         inc++;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args)throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for(int i = 0;i < 5;i ++ ){
            threadPool.execute(() ->{
                for(int j = 0;j < 500;j ++ ){
                    volatileAtomicityDemo.incr();
                }
            });
        }
        Thread.sleep(1000);
        System.out.println(inc);
    }
}
