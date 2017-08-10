package com.example.dao;

import com.example.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CourseDAO {

    public void save(EntityManagerFactory entityManagerFactory) {
        Course course = new Course("course4", 5, 900000.00);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(course);

        transaction.commit();

        entityManager.close();


    }

    public void update(EntityManagerFactory entityManagerFactory) {

//        Course course = new Course(3,"Spring",3,900000.00);
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        transaction.begin();
//
//        entityManager.persist(course);
//
//        transaction.commit();
//
//        entityManager.close();


        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Course course = entityManager.find(Course.class, 3);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        course.setTitle("xyz");

        transaction.commit();

    }

    public void readById(EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();
        Course course = entityManager.find(Course.class, 3);
        System.out.println(course.toString());
    }

    public void delete(EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Course course = entityManager.find(Course.class, 2);
        entityManager.remove(course);
        transaction.commit();
        entityManager.close();

    }


}
