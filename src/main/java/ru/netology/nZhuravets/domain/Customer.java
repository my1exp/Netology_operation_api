package ru.netology.nZhuravets.domain;

import lombok.*;
import ru.netology.nZhuravets.service.CustomerService;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer implements ConsolePrintable{
    private int Id;
    private String name;

    public void printToConsole() {
        System.out.println(getId() + name);
    }
}