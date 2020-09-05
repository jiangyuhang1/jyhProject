package com.jyh.spring.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//提供数据库连接的类
public class DBConnection {
    private static Properties properties = new Properties();

    static {
        /** 要从CLASSPATH下取.properties文件，因此要加"/" */
        //getResourceAsStream属于Class对象
        InputStream is = DBConnection.class.getResourceAsStream("/com/jyh/spring/jdbc/db.properties");
        try
        {
            properties.load(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /** 这个mysqlConnection只是为了用来从里面读一个PreparedStatement，不会往里面写数据，因此没有线程安全问题，可以作为一个全局变量 */
    public static Connection mysqlConnection = getConnection();

    //jdbc获取数据库连接的方法
    public static Connection getConnection() {
        Connection con = null;
        try {
            //Class.forName()会初始化一个类，执行静态资源或者静态代码块
            //这里是初始化com.mysql.jdbc.Driver这个类，DriverManager的registerDriver方法注册一个mysql的JDBC驱动
            Class.forName((String)properties.getProperty("mysqlpackage"));

            //现在的版本不初始化加载驱动连接的时候也会找合适的驱动，有驱动jar包就行
            con = DriverManager.getConnection((String)properties.getProperty("mysqlurl"),
                    (String)properties.getProperty("mysqlname"),
                    (String)properties.getProperty("mysqlpassword"));
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
