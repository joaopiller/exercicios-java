package exercicio11.entities;

import exercicio11.interfaces.Printer;

public class ConcretePrinter extends Device implements Printer {
    public ConcretePrinter(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        IO.println("Printer processing: " + doc);
    }

    @Override
    public void print(String doc) {
        IO.println("Printing: " + doc);
    }
}
