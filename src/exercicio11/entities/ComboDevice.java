package exercicio11.entities;

import exercicio11.interfaces.Printer;
import exercicio11.interfaces.Scanner;

public class ComboDevice extends Device implements Printer, Scanner {
    // dispositivo que é scanner e printer ao mesmo tempo

    public ComboDevice(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        IO.println("Combo processing");
    }

    @Override
    public void print(String doc) {
        IO.println("Combo printing: " + doc);
    }

    @Override
    public String scan() {
        return "Combo scan result";
    }
}
