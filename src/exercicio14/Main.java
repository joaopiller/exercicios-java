package exercicio14;

import exercicio14.services.PrintService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        PrintService<Integer> psInt = new PrintService<>();

        IO.print("Quantos valores gostaria de inserir? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            psInt.addValue(value);
        }

        psInt.print();
        IO.println("First: " + psInt.first());

        PrintService<String> psString = new PrintService<>();

        IO.print("\nQuantos nomes gostaria de inserir? ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String value = sc.nextLine();
            psString.addValue(value);
        }

        psString.print();
        IO.println("First: " + psString.first());

        sc.close();
    }
}
