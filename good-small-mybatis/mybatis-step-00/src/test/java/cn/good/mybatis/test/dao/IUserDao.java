package cn.good.mybatis.test.dao;

import cn.good.mybatis.test.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2024/12/14
 **/
public interface IUserDao {

 @Select("SELECT id,userId,userName,userHead\n" +
         "  FROM user\n" +
         " where id = #{id}")
 User queryUserInfo(User req);
 @Select("SELECT id,userId,userName,userHead\n" +
         "From user")
 List<User> queryUserInfoList();
}
