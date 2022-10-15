package ru.netology.nZhuravets.service;


import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.nZhuravets.OperationHistoryApiApplicationTest;


class AsyncInputOperationTest extends OperationHistoryApiApplicationTest {
    @Autowired
    AsyncInputOperationService asyncInputOperationService;
    private StatementService statementService;

}