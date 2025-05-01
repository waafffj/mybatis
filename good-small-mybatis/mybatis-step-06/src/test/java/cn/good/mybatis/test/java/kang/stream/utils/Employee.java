package cn.good.mybatis.test.java.kang.stream.utils;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/2/5
 **/

@Data
@Builder
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private double salary;

    public Employee(Integer id, String name, Integer age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
