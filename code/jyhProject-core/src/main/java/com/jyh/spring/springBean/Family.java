package com.jyh.spring.springBean;

public class Family {
    private Person person;
    private String familyName;

    public Family(Person person, String familyName) {
        this.person = person;
        this.familyName = familyName;
    }

    public String toString() {
        return person.toString() + ", familyName = " + familyName;
    }
}
