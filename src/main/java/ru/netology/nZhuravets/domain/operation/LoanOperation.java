package ru.netology.nZhuravets.domain.operation;

import lombok.*;
import ru.netology.nZhuravets.domain.ConsolePrintable;

@Getter
@Setter
@AllArgsConstructor

public class LoanOperation extends Operations implements ConsolePrintable {
    private int loanId;

    @Override
    public void printToConsole(){
        super.printToConsole();
        System.out.println("Loan Id " + loanId);
    }

}
