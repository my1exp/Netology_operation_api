package ru.netology.nZhuravets.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.nZhuravets.OperationHistoryApiApplicationTest;
import ru.netology.nZhuravets.controller.dto.OperationsDTO;
import ru.netology.nZhuravets.domain.operation.Currency;
import ru.netology.nZhuravets.domain.operation.Operations;
import ru.netology.nZhuravets.service.AsyncInputOperationService;
import ru.netology.nZhuravets.service.StatementService;

import java.util.Queue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.nZhuravets.domain.operation.OperationCreditType.CREDIT;


public class OperationControllerTest extends OperationHistoryApiApplicationTest {

    @Autowired
    private AsyncInputOperationService asyncInputOperationService;


    @Test
    public void getInputOperationsTest() {
        OperationsDTO operations = new OperationsDTO(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        assertEquals(1000, operations.getSum());
        assertEquals("Shoko", operations.getMerchant());
        assertEquals(1, operations.getCustomerId());
        assertEquals(CREDIT, operations.getOperationCreditType());
        assertEquals(Currency.RUB, operations.getCurrency());
    }
    @Test
    public void getOperationTest() {
        OperationsDTO operations = new OperationsDTO(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        assertEquals(1000, operations.getSum());
        assertEquals("Shoko", operations.getMerchant());
        assertEquals(1, operations.getCustomerId());
        assertEquals(CREDIT, operations.getOperationCreditType());
        assertEquals(Currency.RUB, operations.getCurrency());
    }

    @Test
    public void addOperationTest() {
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        asyncInputOperationService.addOperation(operation);
        Queue<Operations> operations = asyncInputOperationService.getOperations();
        assertEquals("[Транзакция №0. 1000.0 в Shoko null]", operations.toString());
    }

    @Test
    public void removeOperationTest(){
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        asyncInputOperationService.addOperation(operation);
        int i = asyncInputOperationService.getOperations().size();
        int operationId = 0;
        asyncInputOperationService.removeOperation(operationId);
        int y = asyncInputOperationService.getOperations().size();
        assertEquals(i, y);
    }
}
