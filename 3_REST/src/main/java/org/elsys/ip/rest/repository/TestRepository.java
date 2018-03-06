package org.elsys.ip.rest.repository;

import org.elsys.ip.rest.config.HibernateUtil;
import org.elsys.ip.rest.model.Test;
import org.hibernate.Session;

import java.util.List;

public class TestRepository {


  public List<Test> getTestList() {
      List<Test> tests;
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();

      tests = session.createQuery("from Test", Test.class)
              .getResultList();

      session.getTransaction().commit();
      return tests;
  }

  public Test getTestById(Integer id) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Test test = session.load(Test.class, id);
      session.getTransaction().commit();
      return test;
  }

  public Test saveTest(Test test) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(test);
    session.getTransaction().commit();
    return test;
  }

  public Test updateTest(Test test) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.merge(test);
      session.getTransaction().commit();
      return test;
  }

  public Test deleteTest(Integer id) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Test test = session.load(Test.class, id);
      session.remove(test);
      session.getTransaction().commit();
      return test;
  }
}
