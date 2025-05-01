package cn.good.mybatis.test.java.itlaoqi.juc;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/21
 **/
public class ThreadPoolSample4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5); // 可调度线程池
        // 延迟三秒执行一次Run方法
        /*scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟3秒执行");
            }
        },3, TimeUnit.SECONDS);*/
        // 成熟的调度框架支持cron表达式
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + "延迟1s执行，每三秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);
    }


}
