package ru.netology.nZhuravets.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.nZhuravets.OperationHistoryApiApplicationTest;
import ru.netology.nZhuravets.domain.operation.Currency;
import ru.netology.nZhuravets.domain.operation.Operations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.nZhuravets.domain.operation.OperationCreditType.CREDIT;

public class StatementServiceTest extends OperationHistoryApiApplicationTest {

    @Autowired
    StatementService statementService;

    @Test
    public void saveOperationsTest(){
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        statementService.saveOperations(operation);
        String operations = statementService.getOperations();
        assertEquals("{1=[Транзакция №0. 1000.0 в Shoko null]}", operations);
    }

    @Test
    public void removeOperationTest(){
       Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
       statementService.saveOperations(operation);
       statementService.removeOperation(1);
        assertEquals("{}", statementService.getOperations());
    }

    @Test
    public void getOperations(){
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        statementService.saveOperations(operation);
        String operations = statementService.getOperations();
        assertEquals("{1=[Транзакция №0. 1000.0 в Shoko null]}", operations);
    }
}
