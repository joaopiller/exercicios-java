package exercicio20;

import exercicio20.entities.Client;

public class Main {
    public static void main(String[] args) {
        String a = "Maria";
        String b = "Alex";

        // hashes devem ser diferentes para valores diferentes!
        IO.println(a.hashCode());
        IO.println(b.hashCode());
        // comparações com hash são mais rápidas que com equals, porém existe uma pequena chance de dois valores diferentes terem o mesmo hash

        Client c1 = new Client("Maria", "maria@gmail.com");
        Client c2 = new Client("Alex", "alex@gmail.com");
        Client c3 = new Client("Alex", "alex@gmail.com");

        IO.println(c1.hashCode());
        IO.println(c2.hashCode());
        IO.println(c3.hashCode()); // igual ao c2

        IO.println(c1.equals(c2)); // false
        IO.println(c2.equals(c3)); // true

        IO.println(c2 == c3); // false, porque os endereços de memória guardados são diferentes

        String x = "oi";
        String y = "oi";
        IO.println(x == y); // true (literais possuem um tratamento especial)
    }
}
