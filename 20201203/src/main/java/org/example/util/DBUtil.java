package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-19-01:04
 **/
public class DBUtil {

    private static final DataSource DS = new MysqlDataSource();

    //多线程学习以后，会优化为双重校验锁的单例模式来使用DataSource
    static{
        ((MysqlDataSource) DS).setUrl("jdbc:mysql://localhost:3306/servlet_blog?user=root&password=zzj123456&useUnicode=true&useSSL=false&characterEncoding=UTF-8");
    }

    public static Connection getConnection(){
        try {
            return DS.getConnection();
        } catch (SQLException e) {
            throw new AppException("DB001", "获取数据库连接失败", e);
        }
    }

    public static void close(Connection c, Statement s){
        close(c, s, null);
    }

    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if(r != null)
                r.close();
            if(s != null)
                s.close();
            if(c != null)
                c.close();
        } catch (SQLException e) {
            throw new AppException("DB002", "释放数据库资源失败", e);
        }
    }
}
