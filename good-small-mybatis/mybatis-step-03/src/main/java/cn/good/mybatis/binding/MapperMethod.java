package cn.good.mybatis.binding;

import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.mapping.SqlCommandType;
import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.session.SqlSession;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @Description 映射器方法
 * @Author wkm
 * @Date 2024/12/20
 **/
public class MapperMethod {
    private final SqlCommand command;

    public MapperMethod(Class<?> mapperInterface,Method method,Configuration configuration) {
        this.command = new SqlCommand(configuration,mapperInterface,method);
    }

    public Object execute(SqlSession sqlSession,Object[] args){
        Object result = null;
        switch (command.getType()){
            case DELETE:
                break;
            case INSERT:
                break;
            case UPDATE:
                break;
            case SELECT:
                result = sqlSession.selectOne(command.getName(),args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + command.getName());
        }
        return result;
    }


    /** SQL 指令*/
    public static class SqlCommand{
        private final String name;
        private final SqlCommandType type;
        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method){
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement ms = configuration.getMappedStatement(statementName);
            name = ms.getId();
            type = ms.getSqlCommandType();
        }
        public String getName(){
            return name;
        }

        public SqlCommandType getType() {
            return type;
        }
    }
}
