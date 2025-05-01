package cn.good.mybatis.test.java.kang.stream;

import cn.good.mybatis.test.java.kang.stream.utils.Employee;
import cn.good.mybatis.test.java.kang.stream.utils.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @Description 测试Stream的终止操作
 * @Author wkm
 * @Date 2025/2/5
 **/
public class StreamTest2 {
    // 1.匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        // allMatch(Predicate p) 检查是否匹配所有元素
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
        // anyMatch(Predicate p) 检查是否至少匹配一个元素
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);
        // noneMatch(Predicate p) 检查是否没有匹配的元素
        boolean b2 = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b2);

        //findFirst 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        // findAny 返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
        // count返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
         //max(Comparator c) 返回流中最大值
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max(Double::compare);
        System.out.println(max);
        // min(Comparator c) 返回流中最小值
        Optional<Double> min = employees.stream().map(e -> e.getSalary()).min(Double::compareTo);
        System.out.println(min);
        // forEach(Consumer c) 内部迭代
        employees.stream().forEach(System.out::println);
    }

    // 2.归约
    @Test
    public void test3(){
        // reduce(T identity,BinaryOperator)-可以将流中元素反复结合起来，得到一个值,返回T
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //reduce(BinaryOperator) 可以将流中元素反复结合起来，得到一个值，返回Optional<T> 放两个参数，返回一个

        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> sumMoney = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(sumMoney);
    }

    // 3.收集
    @Test
    public void test2(){
        // collect(Collector c) 将流转换为其他形式.接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList()).forEach(x -> System.out.println(x));
    }
}
