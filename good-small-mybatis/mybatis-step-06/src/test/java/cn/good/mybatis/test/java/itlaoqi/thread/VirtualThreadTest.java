package cn.good.mybatis.test.java.itlaoqi.thread;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/3/30
 **/
public class VirtualThreadTest {
    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();
    }
}

class CustomThread implements Runnable{

    @Override
    public void run() {
        System.out.println("CustomThread Run");
    }
}
