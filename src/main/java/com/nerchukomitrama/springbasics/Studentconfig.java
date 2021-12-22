package com.nerchukomitrama.springbasics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
//we are creating the configuration file by removing the bean.xml configuration file
@Configuration
//If you use @bean you no need of these componentscan because in @bean we are defining the classes that need objects
@ComponentScan(basePackages = "com.nerchukomitrama.springbasics")
//scans all the base packages that you mentioned .if you don't mention
//it scans all the packages and create beans for that classes in that package.
//instead of defining the beans in xml configuration we are using this studentconfig file
//we can bean in two ways one way by @bean tag and second is use @component
public class Studentconfig {
    //we are creating this method to expose our bean and this method returns the student object
    //by tagging @bean spring creates an object for that particular student class new student -->and registers in Ioc container
/*
    @Bean
    //by using this bean tag we are returning the desired bean object of that particular class
    //we can change the bean id if you want by using name
   // @Bean(name = "get_studentdata")
    public Student getdata(){ //this getdata-->be the bean id (method name)
       // return new Student();
       // return new Student((java.security.Principal) getpricipalname());//<--constructor method injection
        // here we are passing new prinicpal obj to new student constructor obj
        // which calls this below student constructor in student.class
        *//*  public Student(java.security.Principal principal){
            this.principal = principal;
        }*//*
        // and finally like private  Principal priciapl = new principal ()<-- like this created in background
*//*Student student = new Student();
student.setPrincipal((java.security.Principal) getpricipalname());//<--using setter method injection
return student;*//*
        Student student = new Student();
        student.setTeacher(getteachername());
       // student.setPrincipal((java.security.Principal) getpricipalname());
        return student;
    }
    //^^^ inserting this getpricipalmethod in new Student constructor

    @Bean
    public Principal getpricipalname(){
        return new Principal();
    }
    @Bean
    public Teacher getteachername(){
        return new Mathteacher();
    }*/
}
