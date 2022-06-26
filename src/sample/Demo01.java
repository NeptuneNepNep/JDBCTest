package sample;

import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.添加jar包
        //2.加载驱动
        Class.forName("sample.Demo01");
        //通过驱动管理器获取连接对象 url是数据库地址
        String url = "jdbc:mysql://localhost:3306/fruitdb";
        String userName = "root";
        String passWord = "123456";
        Connection conn = DriverManager.getConnection(url,userName,passWord);
        //编写sql语句
        String sql = "insert into fruit values(2,?,?,?,?)";
        //sql语句运输到数据库执行
        //创建预处理命令对象 写sql语句
        PreparedStatement psmt = conn.prepareStatement(sql);
        //填充参数
        psmt.setString(1,"apple");
        psmt.setInt(2,4);
        psmt.setInt(3,100);
        psmt.setString(4,"wonderful");
        //执行更新 返回影响行数
        int count = psmt.executeUpdate();
        psmt.close();
        conn.close();
    }
}
