package exercicio12;

import exercicio12.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        String path = "/Users/joaopiller/Projetos/Exercicios-Java/src/exercicio12/in.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employeeCsv = br.readLine();
            while (employeeCsv != null) {
                String[] fields = employeeCsv.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCsv = br.readLine();
            }
            Collections.sort(list);
            for (Employee emp : list) {
                IO.println(emp.getName() + ", " + emp.getSalary());
            }
        } catch (IOException e) {
            IO.println("Error: " + e.getMessage());
        }
    }
}
