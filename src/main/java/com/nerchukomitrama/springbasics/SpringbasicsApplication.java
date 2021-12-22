package com.nerchukomitrama.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbasicsApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringbasicsApplication.class, args);
        //creating an container(context) for storing the objects
        //Applicationcontext is an interface
        ApplicationContext context= new AnnotationConfigApplicationContext(SpringbasicsApplication.class);
        //Step1:this application context reads the Springbasicapplication.class<--configclass
        //Step2-->go to that config class (studentconfig.class)
        //step3-->go to that componentscan-->package-->studentclass--->has @component
        //step4: @component -->spring creates an object for that class and registers in Ioc/appcontext container
        //using getBean --->we are retreiving that object from ioc container by giving the correct bean_id and name of that class
     /*   Student student=context.getBean("getdata",Student.class);
       student.test();*/
       // Student student= context.getBean("get_studentdata",Student.class);<--changing the bean id
       //lines 20 and 21 we are not using component in student.class,
        //lines20 and21 we use @bean annotaion in configuration and remove the componentscan no need when we use @bean
        //getdata is the method name as beanid see the configuration class line 20
       // Student student= context.getBean("getdata",Student.class);
      Student student=  context.getBean(Student.class);
        student.setName("Ravi");
        System.out.println(student.getName());
        student.test();
        (( AnnotationConfigApplicationContext)context).close();//use the below one so no need to wrap
       // AnnotationConfigApplicationContext configApplicationContext= new AnnotationConfigApplicationContext(SpringbasicsApplication.class);
    }

}
