package com.jyh.spring.jdbc;

import java.util.List;

public class JDBCMain {
    public static void main(String[] args) throws Exception{
        List<Student> studentList = StudentManager.getInstance().querySomeStudents("Betty");
        for (Student student : studentList) {
            System.out.println(student);
        }

        StudentManager.getInstance().addStudents("jyh",26,"123456789");
    }
}
