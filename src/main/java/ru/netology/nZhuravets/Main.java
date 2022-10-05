package ru.netology.nZhuravets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netology.nZhuravets.configuration.AppConfiguration;
import ru.netology.nZhuravets.service.AsyncInputOperationService;
import ru.netology.nZhuravets.service.StatementService;


public class Main {
    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        AsyncInputOperationService asyncInputOperationService = context.getBean(AsyncInputOperationService.class);
        StatementService statementService = context.getBean(StatementService.class);

        asyncInputOperationService.startProcessing();
        System.out.println(statementService.getOperations());



//        CustomerService customerService = new CustomerService();
//        StatementService statementService = new StatementService();
//
//        AsyncInputOperationService asyncInputOperationService = new AsyncInputOperationService(statementService);


    }
}
