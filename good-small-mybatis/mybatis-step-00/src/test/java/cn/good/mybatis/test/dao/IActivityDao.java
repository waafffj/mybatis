package cn.good.mybatis.test.dao;

import cn.good.mybatis.test.po.Activity;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2024/12/14
 **/
public interface IActivityDao {
 Activity queryActivityById(Activity activity);
 Integer insert(Activity activity);
}
