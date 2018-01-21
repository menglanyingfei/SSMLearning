package com.wtu.spring.transaction.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.18 12:44
 */
public class TransactionTest {
    public static void main(String[] args) {
        /*
            JDBC中事务的使用
         */
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///spring_day03",
                    "root", "lxy");
            // 开启事务
            conn.setAutoCommit(false);
            // zhang给li转账500元
            String sql = "update account set balance = balance + ? where username=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 给zhang减去500
            pstmt.setInt(1, -500);
            pstmt.setString(2, "zhang");
            pstmt.executeUpdate();

//            int i = 10 / 0;

            // 给li增加500
            pstmt.setInt(1, 500);
            pstmt.setString(2, "li");
            pstmt.executeUpdate();
            // 提交事务
            conn.commit();
        } catch (Exception e) {
            // 事务回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}












