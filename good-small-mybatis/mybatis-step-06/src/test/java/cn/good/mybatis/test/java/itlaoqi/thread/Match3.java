package cn.good.mybatis.test.java.itlaoqi.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/20
 **/
public class Match3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个线程池。里面天生有3个"空线程"。Executors是调度器，对线程池进行管理
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Runner3 liuxiang = new Runner3("刘翔");
        Runner3 yx = new Runner3("yx");
        // 将这个对象扔到线程池中，线程池自动分配一个线程来运行liuxiang这个对象的call
        // Future用于接受线程内部call方法的返回值
        Future<Integer> result1 = executorService.submit(liuxiang);
        Future<Integer> result2 = executorService.submit(yx);
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("刘翔累计跑了" + result1.get() + "米");
        System.out.println("yx累计跑了" + result2.get() + "米");
    }
}
class Runner3 implements Callable<Integer>{
    private String name;
    public void setName(String name){
        this.name = name;
    }
    Runner3(String name){
        this.name = name;
    }
    // 实现Callable接口可以允许我们的线程返回值或抛出异常
    @Override
    public Integer call() throws Exception {
        Integer speed = new Random().nextInt(100);
        Integer distance = 0;
        for(int i = 1;i <= 10;i ++ ){
            Thread.sleep(10);
            distance = i * speed;
            System.out.println(this.name + "已前进" + distance + "米");
        }
        return distance;
    }
}
