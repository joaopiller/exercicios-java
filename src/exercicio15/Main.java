package exercicio15;

import exercicio15.entities.Product;
import exercicio15.services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        String path = "/Users/joaopiller/Projetos/Exercicios-Java/src/exercicio15/in.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Product x = CalculationService.max(list);
            IO.println("Mais caro:");
            IO.println(x);

        } catch (IOException e) {
            IO.println("Error: " + e.getMessage());
        }
    }
}
