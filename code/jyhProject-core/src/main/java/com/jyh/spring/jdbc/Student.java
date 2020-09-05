package com.jyh.spring.jdbc;

public class Student {
    private int        studentId;
    private String    studentName;
    private int        studentAge;
    private String    studentPhone;

    public Student(int studentId, String studentName, int studentAge,
                   String studentPhone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentPhone = studentPhone;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public String toString() {
        return "studentId = " + studentId + ", studentName = " + studentName + ", studentAge = " +
                studentAge + ", studentPhone = " + studentPhone;
    }
}
