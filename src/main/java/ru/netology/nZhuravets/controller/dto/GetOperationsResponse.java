package ru.netology.nZhuravets.controller.dto;

import lombok.Data;

import java.util.List;
@Data
public class GetOperationsResponse {
    private final List<OperationsDTO> operationDTOS;
}
