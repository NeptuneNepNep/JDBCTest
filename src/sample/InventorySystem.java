package sample;

import java.sql.*;
import java.util.stream.StreamSupport;

public class InventorySystem {
    public Connection LinkDB() throws ClassNotFoundException, SQLException {
        Class.forName("sample.InventorySystem");
        String url = "jdbc:mysql://localhost:3306/fruitdb";
        String userName = "root";
        String passWord = "123456";
        Connection conn = DriverManager.getConnection(url, userName, passWord);
        return conn;
    }


    //5个功能分别为查看添加下架退出

    public void ShowTitle() throws ClassNotFoundException, SQLException {
        //连接数据库
        Connection conn = this.LinkDB();
        //编写sql语句
        String sql = "select * from fruit";
        //sql语句运输到数据库执行
        //创建预处理命令对象 写sql语句
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        //解析结果集
        //记录总数
        int count = 0;
        while(rs.next()){

            int fid = rs.getInt(1);
            String fname = rs.getString(2);
            int fprice = rs.getInt(3);
            int fcount = rs.getInt(4);
            count++;
            String remark = rs.getString(5);
            System.out.println("fid="+fid+" "+"fname="+fname+" "+"fprice="+fprice+" fcount="+fcount+" remark="+remark);


        }
        System.out.println("sum:"+count);
        //关闭预处理和连接流
        psmt.close();
        conn.close();
    }
    public void SelectFruitByfid(int id) throws SQLException, ClassNotFoundException {
        Connection conn = LinkDB();
        String sql = "select * from fruit where fid = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1,id);
        ResultSet rs = psmt.executeQuery();
        //设定查询

        int count = 0;
        while(rs.next()){

            int fid = rs.getInt(1);
            String fname = rs.getString(2);
            int fprice = rs.getInt(3);
            int fcount = rs.getInt(4);
            count++;
            String remark = rs.getString(5);
            System.out.println("fid="+fid+" "+"fname="+fname+" "+"fprice="+fprice+" fcount="+fcount+" remark="+remark);


        }
        System.out.println("sum:"+count);
        psmt.close();
        conn.close();


    }
    public void AddFruit(Fruit fruit) throws SQLException, ClassNotFoundException {
       Connection conn = LinkDB();
        String sql = "insert into fruit values(?,?,?,?,?)";
        //sql语句运输到数据库执行
        //创建预处理命令对象 写sql语句
        PreparedStatement psmt = conn.prepareStatement(sql);
        //填充参数

        psmt.setInt(1,fruit.getFid());
        psmt.setString(2,fruit.getFname());
        psmt.setInt(3,fruit.getFprice());
        psmt.setInt(4,fruit.getFcount());
        psmt.setString(5,fruit.getRemark());
        //执行更新 返回影响行数
        int count = psmt.executeUpdate();
        System.out.println("involved data:"+count);
        psmt.close();
        conn.close();

    }
    public void DeleteFruitByFid(int id) throws SQLException, ClassNotFoundException {
        Connection conn = LinkDB();
        String sql = "delete from fruit where fid = ?";
        PreparedStatement psmt =  conn.prepareStatement(sql);
        psmt.setInt(1,id);
        int count = psmt.executeUpdate();
        System.out.println("involved data:"+count);
        psmt.close();
        conn.close();

    }
}
