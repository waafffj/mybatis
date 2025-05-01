package cn.good.mybatis.test.java.kang.stream.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/2/5
 **/
public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"马化腾",34,6000.38));
        list.add(new Employee(1002,"马云",37,6001.38));
        list.add(new Employee(1003,"刘强东",36,6200.38));
        list.add(new Employee(1004,"雷军",26,6040.38));
        return list;
    }
}
