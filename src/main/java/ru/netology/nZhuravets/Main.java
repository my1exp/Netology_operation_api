package ru.netology.nZhuravets;

import ru.netology.nZhuravets.domain.Customer;
import ru.netology.nZhuravets.domain.operation.Currency;
import ru.netology.nZhuravets.domain.operation.Operations;
import ru.netology.nZhuravets.service.AsyncInputOperationService;
import ru.netology.nZhuravets.service.CustomerService;
import ru.netology.nZhuravets.service.StatementService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        CustomerService customerService = new CustomerService();
        StatementService statementService = new StatementService();

        AsyncInputOperationService asyncInputOperationService = new AsyncInputOperationService(statementService);
        asyncInputOperationService.startProcessing();

        System.out.println(statementService.getOperations());

    }
/*
    public static Currency parseInputCurrency(String input) {
        Currency var10000;
        switch (input) {
            case "RUB":
                var10000 = Currency.RUB;
                break;
            case "USD":
                var10000 = Currency.USD;
                break;
            default:
                var10000 = null;
        }
        return var10000;
    }
    }*/
}
