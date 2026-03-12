package exercicio11.entities;

import exercicio11.interfaces.Scanner;

public class ConcreteScanner extends Device implements Scanner {

    public ConcreteScanner(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        IO.println("Scanner processing: " + doc);
    }

    @Override
    public String scan() {
        return "Scanned content";
    }
}
