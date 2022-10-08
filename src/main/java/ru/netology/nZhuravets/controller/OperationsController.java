package ru.netology.nZhuravets.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.nZhuravets.controller.dto.GetOperationsResponse;
import ru.netology.nZhuravets.controller.dto.OperationsDTO;
import ru.netology.nZhuravets.domain.operation.Operations;
import ru.netology.nZhuravets.service.AsyncInputOperationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/operations")
public class OperationsController {

    private final AsyncInputOperationService asyncInputOperationService;


    @GetMapping
    public GetOperationsResponse getInputOperations() {
        Queue<Operations> operations = asyncInputOperationService.getOperations();
        List<OperationsDTO> operationDTOS = new ArrayList<>();
        for (Operations operation : operations) {
            OperationsDTO operationDTO = new OperationsDTO(operation.getOperationCreditType(),
                    operation.getSum(), operation.getCurrency(),operation.getMerchant(), operation.getCustomerId());
            operationDTOS.add(operationDTO);
        }
        return new GetOperationsResponse(operationDTOS);
    }


    @GetMapping("/{customerId}")
    public OperationsDTO getOperation(@PathVariable int customerId) {
        for (Operations operation : asyncInputOperationService.getOperations()) {
            if (operation.getCustomerId() == customerId) {
                OperationsDTO operationsDTO = new OperationsDTO(operation.getOperationCreditType(),
                        operation.getSum(), operation.getCurrency(), operation.getMerchant(), operation.getCustomerId());
                return operationsDTO;
            }
        }
        return null;
    }

   @PostMapping("/{customerId}")
   public void addOperation(@RequestBody Operations operation) {
       asyncInputOperationService.addOperation(operation.getOperationCreditType(),
               operation.getSum(), operation.getCurrency(), operation.getMerchant(), operation.getCustomerId());
   }
}
