package sample;

import java.sql.*;

public class Demo03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("sample.Demo03");
        String url = "jdbc:mysql://localhost:3306/fruitdb";
        String userName = "root";
        String passWord = "123456";
        Connection conn = DriverManager.getConnection(url,userName,passWord);
        //编写sql语句
        String sql = "select * from fruit where fid = ?";
        //sql语句运输到数据库执行
        //创建预处理命令对象 写sql语句
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1,1);
        //执行查询 返回结果集
        ResultSet rs = psmt.executeQuery();
        //解析结果集
        while(rs.next()){
            int fid = rs.getInt(1);
            String fname = rs.getString(2);
            System.out.println(fid+" "+fname);

        }
    }
}
