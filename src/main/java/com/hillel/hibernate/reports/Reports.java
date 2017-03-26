package com.hillel.hibernate.reports;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.hillel.hibernate.entity.Exam;

import javax.persistence.EntityManagerFactory;

public class Reports {

  public List<ExamReport> getExamsResults(String firstName, String lastName, Session session) {
    /*
    Query query = session.createQuery(
        "select new com.hillel.hibernate.reports.ExamReport(s.name, st.lastname, e.grade) " +
            "from Exam e, Subject s, Student st " +
            "where e.student.id = st.id and e.subject.id = s.id " +
            "and st.firstname = :firstname and st.lastname = :lastname"
    );
    */

    Query query = session.createQuery(
        "select new com.hillel.hibernate.reports.ExamReport(e.subject.name, e.student.lastname, e.grade) " +
            "from Exam e " +
            "where e.student.firstname = :firstname and e.student.lastname = :lastname"
    );

    query.setParameter("firstname", firstName);
    query.setParameter("lastname", lastName);
    return query.getResultList();
  }

  public List<Exam> getExamsResultsWithCriteria(String firstName, String lastname,
      Session session) {
    Criteria criteria = session.createCriteria(Exam.class);
    criteria.setMaxResults(10);
    criteria.createAlias("student", "s");
    criteria.add(Restrictions.and(
        Restrictions.eq("s.firstname", firstName),
        Restrictions.eq("s.lastname", lastname)
    ));
    return criteria.list();
  }
}
