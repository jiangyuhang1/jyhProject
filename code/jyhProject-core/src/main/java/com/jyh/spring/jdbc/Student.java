package com.jyh.spring.jdbc;

public class Student {
    private Integer        studentId;
    private String    studentName;
    private Integer        studentAge;
    private String    studentPhone;

    public Student(Integer studentId, String studentName, Integer studentAge,
                   String studentPhone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentPhone = studentPhone;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getStudentAge() {
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
