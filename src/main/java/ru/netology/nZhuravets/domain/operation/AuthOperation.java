package ru.netology.nZhuravets.domain.operation;

import ru.netology.nZhuravets.domain.ConsolePrintable;

public class AuthOperation extends BaseOperation implements ConsolePrintable {
    private String ip;

    @Override
    public void printToConsole() {
        System.out.println();
    }
}
