package com.jyh.spring.springBean;

public class Person {
    private String     personName; // 人的名字
    private int        personAge;    // 人的年龄

    public Person(){

    }
    public Person(String personName, int personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String toString() {
        return "personName = " + personName + ", personAge = " + personAge;
    }
}
