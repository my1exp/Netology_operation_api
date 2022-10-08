package ru.netology.nZhuravets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netology.nZhuravets.service.AsyncInputOperationService;
import ru.netology.nZhuravets.service.StatementService;

@SpringBootApplication
public class OperationHistoryApiApplication {

    public static void main(String[] args){
        SpringApplication.run(OperationHistoryApiApplication.class, args);
    }
}
