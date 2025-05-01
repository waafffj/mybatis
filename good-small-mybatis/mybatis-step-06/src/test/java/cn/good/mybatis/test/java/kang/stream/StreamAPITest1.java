package cn.good.mybatis.test.java.kang.stream;

import cn.good.mybatis.test.java.kang.stream.utils.Employee;
import cn.good.mybatis.test.java.kang.stream.utils.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @Description 测试Stream的中间操作
 * @Author wkm
 * @Date 2025/2/5
 **/
public class StreamAPITest1 {

    // 1-筛选与切片
    @Test
    public void test1(){
        // filter(Predicate p) 接收Lambda，从流中排除某些元素
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getSalary() > 700).forEach(System.out::println);
        System.out.println();
        // limit(n) 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        // skip(n) 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流.
        list.stream().skip(2).forEach(System.out::println);
        System.out.println();
        // distinct()筛选，通过流所生成元素的hashCode() 和 equals() 去除重复元素
        list.stream().distinct().forEach(System.out::println);
    }
    // 2.映射
    @Test
    public void test2(){
        //  map(Function f) -接收一个函数作为参数,将元素转换成其他形式或提取信息,该函数会被应用到每个元素，并将其映射成一个新的元素

        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        // 获取员工姓名长度大于3
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> namesStream = employees.stream().map(Employee::getName);
        namesStream.filter(name -> name.length() >= 3).forEach(System.out::println);
        System.out.println();

        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });
        System.out.println();
        //  flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream<Character> stream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        stream.forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    // 3-排序
    @Test
    public void test3(){
        // sorted() 自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 76, 0, -98);
        list.stream().sorted().forEach(System.out::println);
        // 抛异常 原因:Employee没有实现Comparable接口
        List<Employee> employees = EmployeeData.getEmployees();
        //employees.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com) 定制排序
        employees.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);
    }
}
