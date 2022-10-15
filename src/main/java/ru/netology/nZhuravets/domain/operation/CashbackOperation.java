package ru.netology.nZhuravets.domain.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.netology.nZhuravets.domain.ConsolePrintable;

@Getter
@Setter
@AllArgsConstructor

public final class CashbackOperation extends Operations implements ConsolePrintable {
    private int cashbackAmount;

    public void printToConsole(){
        super.printToConsole();
        System.out.println("Cashback Amount " + cashbackAmount);
    }
}
