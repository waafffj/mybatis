package cn.good.mybatis.test.java.kang.reflection;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/3
 **/
public class Person {
    private String name;
    public int age;


    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String showNation(String nation){
        System.out.println("我的国家是 : " + nation);
        return nation;
    }
    public void show(){
        System.out.println("我是一个人");
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
