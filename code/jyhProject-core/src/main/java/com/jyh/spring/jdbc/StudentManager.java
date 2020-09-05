package com.jyh.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static StudentManager instance = new StudentManager();

    private StudentManager() {

    }

    public static StudentManager getInstance() {
        return instance;
    }

    public List<Student> querySomeStudents(String studentName) throws Exception
    {
        List<Student> studentList = new ArrayList<Student>();
        //获取连接对象
        Connection connection = DBConnection.mysqlConnection;

        //要执行的sql，使用占位符，避免sql注入
        PreparedStatement ps = connection.prepareStatement("select * from student where studentName = ?");
        //执行的参数
        ps.setString(1, studentName);
        //执行查询方法
        ResultSet rs = ps.executeQuery();

        Student student = null;
        while (rs.next()) {
            student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            studentList.add(student);
        }

        //立即回收对象的数据库、JDBC所占的资源
        //先关闭创建的连接
        ps.close();
        //后关闭执行的语句连接
        rs.close();
        return studentList;
    }

    public void addStudents(String studentName,int studentAge, String studentPhone) throws Exception
    {
        //获取连接对象
        Connection connection = DBConnection.mysqlConnection;
        //connection默认自动提交事务，可以手动设置为false
        connection.setAutoCommit(false);

        PreparedStatement ps = connection.prepareStatement("insert into student(studentName,studentAge,studentPhone) values(?,?,?)");
        ps.setString(1,studentName);
        ps.setInt(2,studentAge);
        ps.setString(3,studentPhone);

        try{
            //增删改查都是这个方法
            ps.executeUpdate();
            connection.commit();
        }catch (Exception e){
            //发生异常回滚事务
            e.printStackTrace();
            connection.rollback();
        }finally {
            //先关闭创建的连接
            //立即回收对象的数据库、JDBC所占的资源
            ps.close();
        }
    }
}
