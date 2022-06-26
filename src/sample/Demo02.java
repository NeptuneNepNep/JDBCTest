package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.添加jar包
        //2.加载驱动
        Class.forName("sample.Demo01");
        //通过驱动管理器获取连接对象 url是数据库地址
        String url = "jdbc:mysql://localhost:3306/fruitdb";
        String userName = "root";
        String passWord = "123456";
        Connection conn = DriverManager.getConnection(url,userName,passWord);
        //编写sql语句
        String sql = "update fruit set fname = ? where fid = 1";
        //sql语句运输到数据库执行
        //创建预处理命令对象 写sql语句
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1,"melon");
        int count = psmt.executeUpdate();
        System.out.println(count);
        psmt.close();
        conn.close();

    }
}
