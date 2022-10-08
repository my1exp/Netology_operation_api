package ru.netology.nZhuravets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.nZhuravets.domain.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Component
@AllArgsConstructor
public class CustomerService {
    private final List<Customer> storage = new ArrayList<>();

    public void addCustomer(int id, String name){
        Customer customer = new Customer(id, name);
        storage.add(customer);
    }

    public List<Customer> getCustomers(){
        return storage;
    }
    @PostConstruct
    public void init(){
        storage.add(new Customer(1, "Nikita"));
        storage.add(new Customer(2,"Oleg"));

    }
}