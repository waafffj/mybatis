package cn.good.mybatis.test.java.itlaoqi.thread;

import java.util.Random;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/20
 **/
public class Match2 {
    public static void main(String[] args) {
        Runner2 liuxiang = new Runner2();
        Thread thread1 = new Thread(liuxiang);
        thread1.setName("刘翔");
        Thread yx = new Thread(new Runner2());
        yx.setName("yx");
        thread1.start();
        yx.start();
    }

}
class Runner2 implements Runnable{

    @Override
    public void run() {
        Integer speed = new Random().nextInt(100);
        for(int i = 1;i <= 100;i ++ ){
            try {
                Thread.sleep(1000); // 当前线程休眠1秒
            }catch (Exception e){
                e.printStackTrace();
            }
            // Thread.currentThread()用于获取当前执行的线程对象
            // 在Runnable中无法使用getName()
            System.out.println(Thread.currentThread().getName() + "已前进" + (i * speed) + "米");
        }
    }
}