package org.example;

import com.example.model.MenuDO;

import java.awt.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcExampleTest {
    Logger logger = Logger.getLogger(JdbcExampleTest.class.getName());

    public static void main(String[] args) {
        JdbcExampleTest exampleTest = new JdbcExampleTest();
        MenuDO menu = exampleTest.getMenu(1);
        System.out.println("menu : " +menu.getTitle());
    }

    private MenuDO getMenu(int id) {
        Connection connection = this.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
                // 操作 Connection，打开 Statement 对象
            ps = connection.prepareStatement("select * from menu where id = ?");
            ps.setLong(1,id);
            // 通过 Statement 执行 SQL，返回结果到 ResultSet 对象
            rs = ps.executeQuery();
            // 通过 ResultSet 读取数据，然后通过代码转化为具体的 POJO 对象
            while (rs.next()){
                Long ID = rs.getLong("id");
                String title = rs.getString("title");
                String path = rs.getString("path");
                MenuDO menu = new MenuDO();
                menu.setId(ID);
                menu.setTitle(title);
                menu.setPath(path);
                return menu;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }finally {
            this.close(rs, ps, connection);
        }
        return null;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/mybatis1?useSSL=false&useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String password = "Wm123456";
            // 最初的版本
            Driver driver = new com.mysql.cj.jdbc.Driver();
//            Properties properties= new Properties();
//            properties.put("user",user);
//            properties.put("password",password);
//            connection= driver.connect(url,properties);
            // 在jdk1.6之前或者说jdbc4.0之前  forName 或 new 一下
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return null;
        }
        return connection;
    }

    private void close(ResultSet rs, Statement stmt, Connection connection) {
        try{
            if(rs !=null && !rs.isClosed()){
                rs.close();
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        try {
            if (stmt != null && !stmt.isClosed()){
                stmt.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,null,e);
        }
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,null,e);
        }
    }
}
