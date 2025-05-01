package cn.good.mybatis.scripting.xmltags;

import cn.good.mybatis.reflection.MetaObject;
import cn.good.mybatis.session.Configuration;
import ognl.OgnlContext;
import ognl.OgnlException;
import ognl.OgnlRuntime;
import ognl.PropertyAccessor;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Description 动态上下文
 * @Author wkm
 * @Date 2025/4/30
 **/
public class DynamicContext {
    public static final String PARAMETER_OBJECT_KEY = "_parameter";
    public static final String DATABASE_ID_KEY = "_databaseId";
    static {
        OgnlRuntime.setPropertyAccessor(ContextMap.class,new ContextAccessor());
    }
    private final ContextMap bindings;
    private final StringBuilder sqlBuilder = new StringBuilder();
    private int uniqueNumber = 0;

    public DynamicContext(Configuration configuration,Object parameterObject) {
        // 绝大多数调用的地方parameterObject为null
        if(parameterObject != null && (parameterObject instanceof Map)){
            MetaObject metaObject = configuration.newMetaObject(parameterObject);
            bindings = new ContextMap(metaObject);
        }else {
            bindings = new ContextMap(null);
        }
        bindings.put(PARAMETER_OBJECT_KEY,parameterObject);
        bindings.put(DATABASE_ID_KEY,configuration.getDatabaseId());
    }

    public Map<String, Object> getBindings() {
        return bindings;
    }

    public void bind(String name, Object value) {
        bindings.put(name, value);
    }

    public void appendSql(String sql) {
        sqlBuilder.append(sql);
        sqlBuilder.append(" ");
    }

    public String getSql() {
        return sqlBuilder.toString().trim();
    }

    public int getUniqueNumber() {
        return uniqueNumber++;
    }


    // 上下文map,静态内部类
    static class ContextMap extends HashMap<String,Object>{
        private static final long serialVersionUID = 2977601501966151582L;
        private MetaObject parameterMetaObject;

        public ContextMap(MetaObject parameterMetaObject) {
            this.parameterMetaObject = parameterMetaObject;
        }

        @Override
        public Object get(Object key) {
            String  strKey = (String) key;
            // 先去map中找
            if(super.containsKey(strKey)){
                return super.get(strKey);
            }
            // 如果没找到，再用ognl表达式去取值
            if(parameterMetaObject != null){
                return parameterMetaObject.getValue(strKey);
            }
            return null;
        }
    }
    // 上下文访问器,静态内部类,实现OGNL的PropertyAccessor
    static class ContextAccessor implements PropertyAccessor{

        @Override
        public Object getProperty(Map context, Object target, Object name) throws OgnlException {
            Map map = (Map) target;
            Object result = map.get(name);
            if(result != null){
                return result;
            }
            Object parameterObject = map.get(PARAMETER_OBJECT_KEY);
            if(parameterObject instanceof Map){
                return ((Map)parameterObject).get(name);
            }
            return null;
        }

        @Override
        public void setProperty(Map context, Object target, Object name, Object value) throws OgnlException {
            Map<Object,Object> map = (Map<Object, Object>) target;
            map.put(name,value);
        }

        @Override
        public String getSourceAccessor(OgnlContext ognlContext, Object o, Object o1) {
            return null;
        }

        @Override
        public String getSourceSetter(OgnlContext ognlContext, Object o, Object o1) {
            return null;
        }
    }
}
