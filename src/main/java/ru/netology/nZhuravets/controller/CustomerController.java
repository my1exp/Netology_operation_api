package ru.netology.nZhuravets.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.nZhuravets.controller.dto.CustomersDTO;
import ru.netology.nZhuravets.controller.dto.GetCustomersResponse;
import ru.netology.nZhuravets.domain.Customer;
import ru.netology.nZhuravets.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public GetCustomersResponse getCustomers(){
        List<Customer> customers = customerService.getCustomers;
        List<CustomersDTO> customerDTOS = new ArrayList<>();
        for (Customer customer: customers) {
            CustomersDTO customerDTO = new CustomersDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setName(customer.getName());
            customerDTOS.add(customerDTO);
        }
        return new GetCustomersResponse(customerDTOS);
    }
}

