package exercicio1;

import exercicio1.entities.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = 3;

        List<Pessoa> pessoas = new ArrayList<>();

        IO.println("Calculadora de IMC\n");
        for (int i = 0; i < n; i++) {
            IO.println("Pessoa " + (i + 1));
            IO.print("Nome: ");
            String nome = sc.nextLine();
            IO.print("Altura: ");
            double altura = sc.nextDouble();
            IO.print("Peso: ");
            double peso = sc.nextDouble();
            sc.nextLine();
            IO.println("");
            pessoas.add(new Pessoa(nome, altura, peso));
        }

        double maiorImc = 0;
        String nome = "";
        for (Pessoa pessoa : pessoas) {
            IO.println(pessoa);
            if (pessoa.imc() > maiorImc) {
                maiorImc = pessoa.imc();
                nome = pessoa.getNome();
            }
        }

        IO.println("\nPessoa com maior IMC: " + nome);
        sc.close();
    }
}
