package ru.netology.nZhuravets.service;

import lombok.AllArgsConstructor;
import ru.netology.nZhuravets.domain.operation.Operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class StatementService {
    public final Map<Integer, List<Operations>> storage = new HashMap<>();

    public void saveOperations(Operations operation){
        List<Operations> operations = storage.get(operation.getCustomerId());
        if (operations == null){
            List<Operations> customerOperations = new ArrayList<>();
            customerOperations.add(operation);
            storage.put(operation.getCustomerId(), customerOperations);
        } else {
            operations.add(operation);
        }
    }

    public String getOperations(){
        return storage.toString();

    }
}
