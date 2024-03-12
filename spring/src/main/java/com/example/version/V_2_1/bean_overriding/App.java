package com.example.version.V_2_1.bean_overriding;

//import com.example.demofamilymanprep.FamilyMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
//            @Autowired
//            FamilyMan familyMan;

            @Override
            public void run(ApplicationArguments args) {
                System.out.println("****************");
//                System.out.println(familyMan.getName());
                System.out.println("****************");
            }
        };
    }

//    @Bean
//    public FamilyMan familyMan() {
//        FamilyMan familyMan = new FamilyMan();
//        familyMan.setName("junwoo");
//        return familyMan;
//    }

}
