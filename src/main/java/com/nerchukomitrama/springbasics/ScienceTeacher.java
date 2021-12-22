package com.nerchukomitrama.springbasics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//If we use the primary tag than this created obj will be injected (by using autowired) and called
//if the interface is implemented by 20 classes , we can use @primary to inject that particular class in dependent class
//^^and called
public class ScienceTeacher implements Teacher{
    @Override
    public void tech() {
        System.out.println("I am a Science teacher : Dhoni");
    }
}
