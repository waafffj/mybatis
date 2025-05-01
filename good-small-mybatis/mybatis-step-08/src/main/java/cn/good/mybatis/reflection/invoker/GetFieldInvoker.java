package cn.good.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @Description 调用者
 * @Author wkm
 * @Date 2025/1/5
 **/
public class GetFieldInvoker implements Invoker{
    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
