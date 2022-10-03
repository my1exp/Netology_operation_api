package ru.netology.nZhuravets.domain.operation;

import lombok.Data;
import ru.netology.nZhuravets.domain.ConsolePrintable;

@Data

public final class CashbackOperation extends Operations implements ConsolePrintable {
    private int cashbackAmount;

    public void printToConsole(){
        super.printToConsole();
        System.out.println("Cashback Amount " + cashbackAmount);
    }
}
