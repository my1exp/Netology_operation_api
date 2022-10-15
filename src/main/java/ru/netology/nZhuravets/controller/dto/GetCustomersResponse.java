package ru.netology.nZhuravets.controller.dto;

import lombok.Data;
import java.util.List;

@Data
public class GetCustomersResponse {
    private final List<CustomersDTO> Customers;
}
