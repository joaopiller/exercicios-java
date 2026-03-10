package exercicio2;

import exercicio2.entities.ContaBancaria;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        IO.print("Nome do titular da primeira conta: ");
        String titular = sc.nextLine();
        IO.print("Número da primeira conta: ");
        int numConta = sc.nextInt();
        sc.nextLine();
        ContaBancaria conta1 = new ContaBancaria(titular, numConta);

        IO.print("\nNome do titular da segunda conta: ");
        titular = sc.nextLine();
        IO.print("Número da segunda conta: ");
        numConta = sc.nextInt();
        ContaBancaria conta2 = new ContaBancaria(titular, numConta);

        IO.print("\nInsira o número da conta que você gostaria de realizar operações: ");
        int num = sc.nextInt();
        ContaBancaria contaOperacoes;
        ContaBancaria contaTransferencia;
        if (num == conta1.getNumeroConta()) {
            contaOperacoes = conta1;
            contaTransferencia = conta2;
        } else if (num == conta2.getNumeroConta()) {
            contaOperacoes = conta2;
            contaTransferencia = conta1;
        } else {
            IO.println("Conta não encontrada. Encerrando.");
            sc.close();
            return;
        }

        IO.println("\nBem vindo(a), " + contaOperacoes.getTitular() + "!");
        int opcao;
        do {
            IO.println("\n1 - Depositar valor\n2 - Sacar valor\n3 - Transferir valor\n4 - Ver extrato\n5 - Sair\n");
            IO.print("Insira o número da operação que gostaria de realizar: ");
            opcao = sc.nextInt();
            IO.println("");
            switch (opcao) {
                case 1:
                    IO.print("Insira o valor do depósito: ");
                    double valorDeposito = sc.nextDouble();
                    try {
                        contaOperacoes.depositar(valorDeposito);
                        IO.println("Valor depositado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        IO.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    IO.print("Insira o valor do saque: ");
                    double valorSaque = sc.nextDouble();
                    try {
                        contaOperacoes.sacar(valorSaque);
                        IO.println("Valor sacado com sucesso!");
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        IO.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    IO.print("Insira o valor da transferência para " + contaTransferencia.getTitular() + ": ");
                    double valorTransferencia = sc.nextDouble();
                    try {
                        contaOperacoes.transferir(contaTransferencia, valorTransferencia);
                        IO.println("Valor transferido com sucesso!");
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        IO.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    IO.println(contaOperacoes);
                    break;
                case 5:
                    IO.println("Programa encerrado!");
                    break;
                default:
                    IO.println("Insira uma opção válida!");
            }
        } while (opcao != 5);
        sc.close();
    }
}
