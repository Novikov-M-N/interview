package com.github.novikovmn.interview.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {}

    @Override
    public String toString() {
        return "Student("
                + "id=" + id
                + ", name=" + name
                + ", age=" + age
                + ")";
    }
}
