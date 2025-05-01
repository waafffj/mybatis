package cn.good.mybatis.test.java.itlaoqi.juc;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/21
 **/
public class SemaphoreSample1 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(5); // 定义5个信号量，也就是说服务器只允许5个人在里面玩
        for(int i = 1;i <= 20;i ++ ){
            final int index = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire(); // 获取一个信号量,"占到一个跑道“
                        play();
                        semaphore.release();// 执行完成后释放这个信号量,"从跑道出去"
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
    private static void play(){
        try {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ":获得进入服务器资格");
            Thread.sleep(2000);
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ":退出服务器");
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
