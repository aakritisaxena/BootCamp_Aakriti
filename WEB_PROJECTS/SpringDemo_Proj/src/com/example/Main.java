package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springDemo.xml");
        Employee employee = (Employee) context.getBean("employee");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getPhone());
    }
}
