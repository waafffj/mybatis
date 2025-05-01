package cn.good.mybatis.test.java.itlaoqi.juc;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/31
 **/
public class VolatileDemo {
    static volatile int flag = 0;

    public synchronized static void main(String[] args) {
        new Thread(() ->{
            int localFlag = flag;
            while (true){
                if(localFlag != flag){
                    System.out.println("读取到了修改后的标志位: " + flag);
                    localFlag = flag;
                }
            }
        }).start();
        new Thread(()->{
            int localFlag = flag;
            while(true){
                System.out.println("标志位被修改为:" + ++localFlag);
                flag = localFlag;
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
