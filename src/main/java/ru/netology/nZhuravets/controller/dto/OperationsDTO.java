package ru.netology.nZhuravets.controller.dto;

import lombok.Data;
import ru.netology.nZhuravets.domain.operation.Currency;
import ru.netology.nZhuravets.domain.operation.OperationCreditType;

@Data
public class OperationsDTO {
    private final OperationCreditType operationCreditType;
    private final double sum;
    private final Currency currency;
    private final String merchant;
    private final int customerId;

}
