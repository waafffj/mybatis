package cn.good.mybatis.type;

import cn.good.mybatis.io.Resources;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * TODO
 *
 * @Description 类型别名注册机 用于管理和解析类型别名到实际 Java 类的映射
 * @Author wkm
 * @Date 2024/12/21
 **/
public class TypeAliasRegistry {
    private final Map<String, Class<?>> TYPE_ALIASES = new HashMap<>();

    public TypeAliasRegistry() {
        // 构造函数里注册系统内置的类型别名
        registerAlias("string", String.class);

        // 基本包装类型
        registerAlias("byte", Byte.class);
        registerAlias("long", Long.class);
        registerAlias("short", Short.class);
        registerAlias("int", Integer.class);
        registerAlias("integer", Integer.class);
        registerAlias("double", Double.class);
        registerAlias("float", Float.class);
        registerAlias("boolean", Boolean.class);
    }

    public void registerAlias(String alias, Class<?> value) {
        String key = alias.toLowerCase(Locale.ENGLISH);
        TYPE_ALIASES.put(key, value);
    }

    /**
     * 用于将字符串解析为对应的Java类对象
     * @param string
     * @return
     * @param <T>
     */
    public <T> Class<T> resolveAlias(String string) {
        try {
            if (string == null) {
                return null;
            }
            /*  将输入字符串转换为小写 */
            String key = string.toLowerCase(Locale.ENGLISH);
            Class<T> value;
            if(TYPE_ALIASES.containsKey(key)){
                value = (Class<T>) TYPE_ALIASES.get(key);
            }else{
                value = (Class<T>) Resources.classForName(string);
            }
            return value;
        }catch (ClassNotFoundException e){
            throw new RuntimeException("Could not resolve type alias '" + string + "'.  Cause: " + e, e);
        }
    }
}