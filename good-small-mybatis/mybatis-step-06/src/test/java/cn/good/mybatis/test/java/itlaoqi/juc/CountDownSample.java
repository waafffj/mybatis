package cn.good.mybatis.test.java.itlaoqi.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/21
 **/
public class CountDownSample {
    private static int count = 0;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        CountDownLatch cdl = new CountDownLatch(10000); //CDL总数和操作数保持一致
        for(int i = 1;i <= 10000;i ++ ){
            final int index = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (CountDownSample.class){
                        try{
                            count = count + index;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            cdl.countDown(); // 计数器减一
                        }
                    }
                }
            });
        }
        try {
            cdl.await(); // 堵塞当前线程，直到cdl=0再往下走
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
        threadPool.shutdown();
    }
}
