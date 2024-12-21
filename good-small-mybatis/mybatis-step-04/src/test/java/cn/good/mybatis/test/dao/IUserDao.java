package cn.good.mybatis.test.dao;

import cn.good.mybatis.test.po.User;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2024/12/17
 **/
public interface IUserDao {
    User queryUserInfoById(Long uId);
}

