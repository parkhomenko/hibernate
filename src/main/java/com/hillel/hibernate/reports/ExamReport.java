package com.hillel.hibernate.reports;

public class ExamReport {

  private String subject;
  private String student;
  private int grade;

  public ExamReport(String subject, String student, int grade) {
    this.subject = subject;
    this.student = student;
    this.grade = grade;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getStudent() {
    return student;
  }

  public void setStudent(String student) {
    this.student = student;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }
}
