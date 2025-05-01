package cn.good.mybatis.test.java.itlaoqi.juc;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/21
 **/
public class CountDownSample1 {

    public static void main(String[] arg){
        CountDownLatch latch = new CountDownLatch(3);
        for(int i = 0;i < 3;i ++ ){
            final int threadNumber = i + 1;
            new Thread(() ->{
                try {
                    System.out.println("Thread" + threadNumber + "is working");
                    Thread.sleep(10000);
                    System.out.println( threadNumber+ "finished");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    latch.countDown();
                }

            }).start();
        }

        new Thread(() ->{
            try {
                System.out.println("waiting for");
                latch.await();
                System.out.println("All threads have finished, this thread starts to work.");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
