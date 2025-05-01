package cn.good.mybatis.test.java.kang.design;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/16
 **/

/**
 * 单例设计模式:
 * 所谓的单例设计模式,就是采取一定的方法保证整个软件系统中，对某个类只能存在一个对象实例
 */
public class SingletonTest {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
    }
}
// 饿汉式
class Bank{
    /* 1.私有化类的构造器*/
    private Bank(){

    }
    /* 2.内部创建类的对象*/
    /* 4.要求此对象也必须声明为静态的*/
    private static Bank instance = new Bank();
    /* 3. 提供公共的静态的方法，返回类的对象*/
    public static Bank getInstance(){
        return instance;
    }
}
/* 懒汉式 用到对象的时候才创建*/
class Order{
    /* 1.私有化类的构造器*/
    private Order(){

    }
    /* 2.声明当前类的对象，没有初始化*/
    /* 4.此对象也必须声明为static的*/
    private static Order instance = null;
    /* 3.声明public、static的返回当前类对象的方法*/
    public static Order getInstance(){
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }
}
