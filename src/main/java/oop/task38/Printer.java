package oop.task38;

import lombok.Getter;

public class Printer {
    private int tonerLevel;
    @Getter
    private int pagesPrinted;
    private final boolean duplex;


    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel < 0 || tonerLevel > 100)
            throw new IllegalArgumentException("tonerLevel must be in range [0,100]");
        this.tonerLevel = tonerLevel;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount <= 0)
            throw new IllegalArgumentException("tonerAmount should be a positive number");
        if (tonerAmount + tonerLevel > 100)
            throw new IllegalArgumentException("tonerLevel is overflow");
        tonerLevel += tonerAmount;
        return tonerLevel;
    }

    public void printPages(int pages) {
        int pagesToPrint = pages;
        if(duplex){
            pagesToPrint/=2;
        }
        pagesPrinted+=pagesToPrint;
    }
}
