package exercicio11;

import exercicio11.entities.ComboDevice;
import exercicio11.entities.ConcretePrinter;
import exercicio11.entities.ConcreteScanner;

public class Main {
    public static void main(String[] args) {
        ConcretePrinter p = new ConcretePrinter("1080");
        p.processDoc("My Letter");
        p.print("My Letter");

        ConcreteScanner s = new ConcreteScanner("2003");
        p.processDoc("My Email");
        IO.println("Scan result: " + s.scan());

        ComboDevice c = new ComboDevice("2081");
        c.processDoc("My dissertation");
        c.print("My dissertation");
        IO.println("Scan result: " + c.scan());
    }
}
