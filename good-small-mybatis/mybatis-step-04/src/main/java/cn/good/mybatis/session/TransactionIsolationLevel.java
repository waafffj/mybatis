package cn.good.mybatis.session;

import java.sql.Connection;

/**
 * TODO
 *
 * @Description 事务的隔离级别
 * @Author wkm
 * @Date 2024/12/21
 **/
public enum TransactionIsolationLevel {
      NONE(Connection.TRANSACTION_NONE),
      READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
      READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
      REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
      SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);
      private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

 public int getLevel() {
  return level;
 }
}
