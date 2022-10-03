package ru.netology.nZhuravets.service;

import lombok.AllArgsConstructor;
import ru.netology.nZhuravets.domain.Customer;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CustomerService {
    private final List<Customer> storage = new ArrayList<>();

    public void addCustomer(int id, String name){
        Customer customer = new Customer(id, name);
        storage.add(customer);
    }
}
