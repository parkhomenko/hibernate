package com.hillel.hibernate.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "age")
  private int age;

  @Embedded
  private StudentAddress address;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
  private Set<Exam> exams;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public StudentAddress getAddress() {
    return address;
  }

  public void setAddress(StudentAddress address) {
    this.address = address;
  }

  public Set<Exam> getExams() {
    return exams;
  }

  public void setExams(Set<Exam> exams) {
    this.exams = exams;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", age=" + age +
        ", address=" + address +
        ", exams=" + exams +
        '}';
  }
}
