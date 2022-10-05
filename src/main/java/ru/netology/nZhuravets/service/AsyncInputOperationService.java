package ru.netology.nZhuravets.service;

import ru.netology.nZhuravets.domain.operation.Operations;

import java.util.LinkedList;
import java.util.Queue;

public class AsyncInputOperationService {
    private final Queue<Operations> operations = new LinkedList<>();
    private final StatementService statementService;

    public AsyncInputOperationService(StatementService statementService) {
        this.statementService = statementService;
    }

    public boolean addOperation(Operations operation){
        System.out.println("Operation added for processing " + operations);
        return operations.offer(operation);
    }

    public void startProcessing(){
        Thread t = new Thread(){

            public void run(){
                processQueue();
            }
        };
        t.start();
    }

    private void processQueue(){
        while (true){
            Operations operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("No operations");
                    Thread.sleep(1_000);
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
