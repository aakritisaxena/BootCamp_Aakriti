package com.example.client;

import com.example.dao.CourseDAO;
import com.example.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

            CourseDAO couresedao = new CourseDAO();
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("mysql");

//            couresedao.save(managerFactory);
           couresedao.update(managerFactory);
            // couresedao.readById(managerFactory);
//                couresedao.delete(managerFactory);
            managerFactory.close();


    }
}
