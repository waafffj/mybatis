package cn.good.mybatis.test.java.itlaoqi.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/21
 **/
public class FutureSample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 2;i <= 10000;i ++ ){
            Computor c = new Computor();
            c.setNum(i);
            // Future是对用于计算的线程进行监听,因为计算是在其他线程中执行的，所以返回结果的过程是异步的
            Future<Boolean> result = executorService.submit(c);// 将c对象提交给线程池,如有空闲线程池立即执行call方法
            try {
                Boolean r = result.get(); // 用于获取返回值，如果线程内部的call没有执行完成,则进入等待状态
                if(r == true){
                    System.out.println(c.getNum());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
class Computor implements Callable<Boolean> {
    private Integer num;
    public void setNum(Integer num){
        this.num = num;
    }
    public Integer getNum(){
        return num;
    }

    @Override
    public Boolean call() throws Exception {
        boolean isprime = true;
        for(int i = 2;i < num;i ++ ){
            if(num % i == 0){
                isprime = false;
                break;
            }
        }
        return isprime;
    }
}