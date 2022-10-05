package ru.netology.nZhuravets.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.nZhuravets.service.AsyncInputOperationService;
import ru.netology.nZhuravets.service.CustomerService;
import ru.netology.nZhuravets.service.StatementService;

@Configuration
public class AppConfiguration {

    @Bean
    public CustomerService customerService(){
        return new CustomerService();
    }

    @Bean
    public StatementService statementService(){
        return new StatementService();
    }

    @Bean
    public AsyncInputOperationService asyncInputOperationService(StatementService statementService){
        return new AsyncInputOperationService(statementService);
    }
}
