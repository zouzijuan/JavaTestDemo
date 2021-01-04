package test.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * program:20201120
 * description:
 * author:Zou zijuan
 * create:2020-11-20-10:49
 **/
public class Main {

    public static void main(String[] args) {
        query("黑");
    }

    public static void query(String queryName) {
        Connection connection= null;
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {

            //创建数据库连接池
            DataSource ds=new MysqlDataSource();
            ((MysqlDataSource)ds).setUrl("jdbc:mysql://localhost:3306/class?user=root&password=zzj123456&useUnicode=true&useSSL=false&characterEncoding=UTF-8");

            //1.创建数据库连接
            connection=ds.getConnection();

            String sql="select id, sn, name, qq_mail,classes_id from student where name like ?";

            //2.创建操作命令
            statement = connection.prepareStatement(sql);

            //替换占位符
            statement.setString(1,"%"+queryName+"%");

            //3.执行SQL语句
            resultSet = statement.executeQuery();

            //4.处理结果集ResultSet(类似于List<Map<String,字段类型>>)
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String sn=resultSet.getString("sn");
                String name=resultSet.getString("name");
                int classesId=resultSet.getInt("classes_id");
                System.out.println(String.format("Student:id=%d,sn=%s,name=%s,classId=%s",id,sn,name,classesId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //释放资源
                if(resultSet!=null)
                    resultSet.close();
                if(statement!=null)
                    statement.close();
                if(connection!=null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
