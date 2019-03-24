package cn.com.java.thread.lock;


import java.sql.*;

public class JdbcUtils {

    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=Hongkong";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            return null;
        }
    }

    public static void  clean(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void  clean(Statement statement){
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void clean(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }
}
