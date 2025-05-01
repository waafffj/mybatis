package cn.good.mybatis.test.java.itlaoqi.classloader;

public class Base {
    private static int count = 30;
    static{
        count = 40;
        System.out.println("父类<clint>()已执行");
    }
}
