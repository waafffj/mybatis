package cn.good.mybatis.mapping;

import java.util.Map;

/**
 * TODO
 *
 * @Description  绑定的SQL,是从SqlSource而来，将动态内容都处理完成得到的SQL语句字符串，其中包括?,还有绑定的参数
 * @Author wkm
 * @Date 2024/12/21
 **/
public class BoundSql {
 private String sql;
 private Map<Integer,String> parameterMappings;
 private String parameterType;
 private String resultType;

 public BoundSql(String sql, Map<Integer, String> parameterMappings, String parameterType, String resultType) {
  this.sql = sql;
  this.parameterMappings = parameterMappings;
  this.parameterType = parameterType;
  this.resultType = resultType;
 }

 public String getSql() {
  return sql;
 }

 public Map<Integer, String> getParameterMappings() {
  return parameterMappings;
 }

 public String getParameterType() {
  return parameterType;
 }

 public String getResultType() {
  return resultType;
 }

}
