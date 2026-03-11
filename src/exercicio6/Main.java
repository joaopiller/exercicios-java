package exercicio6;

import exercicio6.entities.Funcionario;
import exercicio6.entities.FuncionarioCLT;
import exercicio6.entities.FuncionarioPJ;
import exercicio6.entities.Gerente;
import exercicio6.exceptions.CpfInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        IO.print("Insira o número de funcionários que serão adicionados: ");
        int numFuncionarios = sc.nextInt();
        sc.nextLine();

        for (int i = 0; numFuncionarios > i; i++) {
            IO.print("\nQual será o tipo do funcionário #" + (i+1) + " (CLT/PJ/Gerente)? " );
            String tipoDeFuncionario = sc.nextLine().toLowerCase();
            if (tipoDeFuncionario.equals("clt") || tipoDeFuncionario.equals("pj") || tipoDeFuncionario.equals("gerente")) {
                try {
                    IO.print("Insira o nome do funcionário: ");
                    String nome = sc.nextLine();
                    IO.print("Insira o CPF do funcionário: ");
                    String cpf = sc.next();
                    IO.print("Insira o salário base do funcionário: ");
                    double salarioBase = sc.nextDouble();
                    sc.nextLine();
                    switch (tipoDeFuncionario) {
                        case "clt":
                            listaFuncionarios.add(new FuncionarioCLT(nome, cpf, salarioBase));
                            IO.println("Funcionário CLT adicionado com sucesso!");
                            break;
                        case "pj":
                            listaFuncionarios.add(new FuncionarioPJ(nome, cpf, salarioBase));
                            IO.println("Funcionário PJ adicionário com sucesso!");
                            break;
                        case "gerente":
                            IO.print("Insira o bônus salarial desse gerente: ");
                            double salarioBonus = sc.nextDouble();
                            sc.nextLine();
                            listaFuncionarios.add(new Gerente(nome, cpf, salarioBase, salarioBonus));
                            IO.println("Gerente adicionado com sucesso!");
                            break;
                    }
                } catch (CpfInvalidoException e) {
                    IO.println("Error: " + e.getMessage());
                    i--;
                }
            } else {
                IO.println("Insira um tipo válido de funcionário!");
                i--;
            }
        }

        IO.println("\nFuncionários registrados: ");
        listaFuncionarios.forEach(IO::println);

        double total = listaFuncionarios.stream()
                .map(Funcionario::calcularSalario)
                .reduce(0.0, (acumulador, salario) -> acumulador + salario);
        IO.println("\nFolha de pagamento = R$ " + String.format("%.2f", total));

        sc.close();
    }
}
