package cn.good.mybatis.session;

/**
 * TODO
 *
 * @Description 工厂模式接口,构建SqlSession的工厂
 * @Author wkm
 * @Date 2024/12/17
 **/
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
