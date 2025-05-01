package cn.good.mybatis.reflection.invoker;

/**
 * TODO
 *
 * @Description 调用者
 * @Author wkm
 * @Date 2025/1/5
 **/
public interface Invoker {
    Object invoke(Object target,Object[] args) throws Exception;
    Class<?> getType();
}
