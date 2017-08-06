package org.cdk.annotations;

import com.example.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("org/cdk/annotations/springDemo.xml");
        org.cdk.annotations.Employee employee = (org.cdk.annotations.Employee) context.getBean("employee");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getPhone());
        System.out.println(employee.getAddress().getCity());

    }
}
