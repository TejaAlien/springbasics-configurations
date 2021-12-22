package com.nerchukomitrama.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.security.Principal;

//we can use @bean also like in configuration class which will create an obj for the student class and
//register in spring ioc container
/*@Bean
public Student getdata(){
        return new Student();
        }*/
//@Component("student_id")//<--It's a bean to create an obj for this particular class.
//@component--< this one is a default bean id without name consider class name as bean id
//^^ if you don't mention bean id
//if we don't want to use component you need to give the bean detils in bean.xml file as alternative approach
//if you don't want to use component annotation use @bean annotation mehtod <--retrives this class obj which
// declare in that configuration
//creating an object for this particular class and register in ioc container
@Component
public class Student {
    //@value annotation is used to inject the values in the literals either string or int ...
    //we can also pass the vlaues by creating properties file<--student-value.properties
    //inside mention like college.Name ="SRKIT"
    //@Value("${college.Name}")
    //keypoint: @propertySource("classpath:student-value.properties")mention in configuration file (studentonfig)
    //@required tag used  -->property collegeName is required for a bean college(if you don't pass any value in the field)
    //if you don't use @required the college field will be null (if not declared value)
    @Value("SRKIT")
    private String college;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }



    //this student class is dependent on the principal class
//lets say we have a dependency over here

    //how to do the dependency injection for the below Principal class
     private Principal principal;
    //^^ the value for this prinicipal obj  is null because obj haven't created yet
    // we are injecting the principal dependency int the student constructor <--one approach
    //If the object is not injected in student constructor we will get null pointer exception
    //using constructor to inject dependncy
  // @Autowired
   public Student(Principal principal){
        this.principal = principal;
    }
    //using setter to inject dependency
   // private com.nerchukomitrama.springbasics.Principal principal;


    //if you use @autowired no need to use setter or constructor to inject the dependency in student class
    @Autowired
    @Qualifier("scienceTeacher")//<-- this @qualifier annotation inject the science teacher object here so it don't call
    //inject the math teacher obj here
    //if we don't use @qualifier we will get error like
    //expecting a single matching bean but found two:scienceteacher and mathteacher
 private Teacher teacher;
   //this above @autowired annotation inject either of these objects because interface implemented by two classes
    /*Teacher teacher = new Mathteacher();
    Teacher teacher = new ScienceTeacher();*/

/*public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }*/

    public void test (){
        System.out.println("For testing this class");
        teacher.tech();
        //principal.nameinfo();

    }
}
//key point:
//@component is used to create the object for that particular class in spring ioc container
//@autowired is used to inject that particular obj (@component) in the dependent class