package ru.netology.nZhuravets.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.nZhuravets.configuration.OperationProcessingProperties;
import ru.netology.nZhuravets.domain.operation.Currency;
import ru.netology.nZhuravets.domain.operation.OperationCreditType;
import ru.netology.nZhuravets.domain.operation.Operations;
import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;

import static ru.netology.nZhuravets.domain.operation.OperationCreditType.CREDIT;


@Component
@RequiredArgsConstructor
public class AsyncInputOperationService {
    private final Queue<Operations> operations = new LinkedList<>();
    private final StatementService statementService;
    private final OperationProcessingProperties properties;


    @PostConstruct
    public void init(){
        this.startProcessing();
    }

    public void addOperation(OperationCreditType operationCreditType, double sum, Currency currency,
                             String merchant, int customerId){
        Operations operation = new Operations();
        operations.add(operation);
    }

    public void getOperations(int operationId){
        statementService.getOperations();
    }

    @PostConstruct
    public void addTestOperation(){
        Operations operation = new Operations(CREDIT,1000, Currency.RUB, "Shoko", 1);
        operations.add(operation);
    }


    public void removeOperation(int operationId){
        operations.remove(operationId);
    }

    public Queue<Operations> getOperations(){
        return operations;
    }
    public boolean addOperation(Operations operation){
        System.out.println("Operation added for processing " + operations);
        return operations.offer(operation);
    }

    public void startProcessing(){
        Thread t = new Thread(() -> processQueue());
        t.start();
    }

    private void processQueue(){
        while (true){
            Operations operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("No operations");
                    Thread.sleep(properties.getTimeout());
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            else{
                System.out.println("Processing operation " + operation);
                processOperation(operation);
            }
        }
    }
    private void processOperation(Operations operation){
        statementService.saveOperations(operation);
    }
}
