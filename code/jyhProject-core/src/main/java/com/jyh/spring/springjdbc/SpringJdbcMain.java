package com.jyh.spring.springjdbc;

import com.jyh.spring.jdbc.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcMain {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("/com/jyh/spring/springjdbc/springjdbc.xml");
        System.out.println(StudentManagement.getInstance());
        System.out.println(StudentManagement.getInstance().getJdbcTemplate());

        //插入一条数据
        //Student sd = new Student(null,"jyh",27,"1234567890");
        //StudentManagement.getInstance().addStudent(sd);

        //删除一条数据
        StudentManagement.getInstance().deleteStudent(7);

        //更新一条数据
        Student sd = new Student(6,"jyh1",1,"1234567890111");
        StudentManagement.getInstance().updateStudent(6,sd);

        StudentManagement.getInstance().getStudent(6).toString();

        StudentManagement.getInstance().getStudents();

    }
}
