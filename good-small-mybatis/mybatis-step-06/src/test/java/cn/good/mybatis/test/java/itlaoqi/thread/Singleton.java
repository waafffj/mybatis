package cn.good.mybatis.test.java.itlaoqi.thread;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/4/2
 **/
public class Singleton {
    private volatile static Singleton uniqueSingleton;


    public static Singleton getUniqueSingleton(){
        if(uniqueSingleton == null){
            synchronized (Singleton.class){
                if(uniqueSingleton == null){
                    uniqueSingleton = new Singleton();
                }
            }
        }
        return uniqueSingleton;
    }
}
