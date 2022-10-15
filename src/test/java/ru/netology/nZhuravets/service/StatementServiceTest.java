package ru.netology.nZhuravets.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.nZhuravets.domain.operation.Currency;
import ru.netology.nZhuravets.domain.operation.Operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.nZhuravets.domain.operation.OperationCreditType.CREDIT;

public class StatementServiceTest {

    @Autowired
    public  Map<Integer, List<Operations>> storage = new HashMap<>();
    @Autowired
    public StatementService statementService;

    @Test
    public void saveOperationsTest(){
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        statementService.saveOperations(operation);
        List<Operations> operations = storage.get(operation.getCustomerId());
        assertEquals(1, operations);

    }


}
