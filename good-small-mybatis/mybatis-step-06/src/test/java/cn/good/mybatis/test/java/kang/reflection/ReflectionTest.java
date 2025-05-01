package cn.good.mybatis.test.java.kang.reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/3
 **/
public class ReflectionTest {
    /* 反射之前，对于Person的操作 */
    @Test
    public void test1(){
        Person p1 = new Person("TOM",12);
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
        /*  在Person类外部，不可以通过Person类的对象调用其内部私有结构*/

    }
    /* 反射之后  运行时动态性*/
    @Test
    public void test2() throws Exception{
        Class<?> clazz = Class.forName("cn.good.mybatis.test.java.kang.reflection.Person");
        /* 通过反射，创建Person类的对象*/
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("TOM", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        /* 通过反射，调用对象指定的属性、方法*/
        /* 调用属性 */
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        /* 调用方法*/
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        System.out.println("************************************");
        /*通过反射，可以调用Person类(运行时类)的私有结构，比如:私有的构造器、方法、属性*/
        /* 调用私有的构造器*/
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        /* 调用私有的属性*/
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"WWW");
        System.out.println(p1);
        /* 调用指定的私有的方法*/
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        /* 为了对类中的参数进行修改我们取消安全检查 */
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
        System.out.println("********************************");
        /* 获取类中定义的所有方法 */
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }
    }
    /*
     * 关于java.lang.Class类的理解
     * 1.类的加载过程：
     * 程序经过javac.exe命令之后，会生成一个或多个字节码文件(.class结尾)
     * 接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中
     * 此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例
     * 换句话说，Class的实例就对应着一个运行时类.
     *
     * 加载到内存中的运行时类，会缓存一定的时间。在此时之间内，我们可以通过不同的方式来获取此运行时类
     * */

    /* 获取Class的实例的方式(前三种方式需要掌握)*/
    @Test
    public void test3() throws Exception{
        /* 方式一 调用运行时类的属性 : .class*/
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        /* 方式二 通过运行时类的对象，调用getClass()*/
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        /*  调用Class的静态方法: forName(String classPath)*/
        Class clazz3 = Class.forName("cn.good.mybatis.test.java.kang.reflection.Person");
        System.out.println(clazz3);
        /* 方式四 使用类的加载器 ClassLoader*/
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("cn.good.mybatis.test.java.kang.reflection.Person");
        System.out.println(clazz4);
    }

    /* Class实例可以是哪些结构的说明*/
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        /* 只要元素类型和维度一样，就是同一个Class */
        System.out.println(c10 == c11);
    }
}
