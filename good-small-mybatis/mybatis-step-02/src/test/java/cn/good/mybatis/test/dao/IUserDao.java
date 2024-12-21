package cn.good.mybatis.test.dao;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2024/12/17
 **/
public interface IUserDao {
    String queryUserName(String uId);
    Integer queryUserAge(String uId);
}

