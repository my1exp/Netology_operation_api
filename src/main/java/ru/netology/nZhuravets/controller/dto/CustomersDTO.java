package ru.netology.nZhuravets.controller.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class CustomersDTO {
    private int id;
    private String name;

    public CustomersDTO() {
    }
}
