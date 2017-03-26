package com.hillel.hibernate.main;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hillel.hibernate.entity.Exam;
import com.hillel.hibernate.entity.Student;
import com.hillel.hibernate.entity.StudentAddress;
import com.hillel.hibernate.entity.Subject;
import com.hillel.hibernate.reports.ExamReport;
import com.hillel.hibernate.reports.Reports;

public class Main {

  public static void main(String[] args) {

    SessionFactory sessionFactory =
        new Configuration()
            .configure()
            .buildSessionFactory();

    Session session = sessionFactory.openSession();

    Transaction transaction = session.beginTransaction();

    /*
    Query<Student> query = session.createQuery("from Student where id = 2");
    Student student = query.getSingleResult();
    */

    /*
    Student student = new Student();
    student.setFirstname("John");
    student.setLastname("White");
    student.setAge(35);

    session.save(student);
    */

    //Student student = session.get(Student.class, 5);

    /*
    Student student = session.load(Student.class, 3);
    System.out.println(student);

    student.setAge(30);

    StudentAddress studentAddress = new StudentAddress();
    studentAddress.setCountry("Ukraine");
    studentAddress.setCity("Odessa");
    studentAddress.setAddress("Observatorniy Lane");

    student.setAddress(studentAddress);

    transaction.commit();
    */

    /*
    Student student = session.get(Student.class, 2);
    Subject subject = session.get(Subject.class, 2);
    Exam exam = new Exam();
    exam.setSubject(subject);
    exam.setStudent(student);
    exam.setGrade(5);
    session.save(exam);
    */

    //System.out.println(exams);
    //System.out.println(student);

    Reports reports = new Reports();
    //List<ExamReport> exams = reports.getExamsResults("Doe", "John", session);
    List<Exam> exams = reports.getExamsResultsWithCriteria("Doe", "John", session);

    session.close();
    sessionFactory.close();
  }

}
