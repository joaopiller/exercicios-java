package exercicio4;

import exercicio4.entities.Tarefa;
import exercicio4.enums.Prioridade;
import exercicio4.services.GerenciadorTarefas;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();

        IO.println("╔══════════════════════════════════╗");
        IO.println("║     GERENCIADOR DE TAREFAS       ║");
        IO.println("╚══════════════════════════════════╝\n");

        IO.print("Gostaria de adicionar uma tarefa (s/n)? ");
        char opcao = sc.next().charAt(0);
        sc.nextLine();

        while (opcao == 's') {
            IO.println("\n── Nova Tarefa ──────────────────");
            IO.print("Insira uma descrição para a tarefa: ");
            String descricao = sc.nextLine();
            IO.print("Insira a prioridade da tarefa (baixa,media,alta): ");
            Prioridade prioridade = Prioridade.valueOf(sc.next().toUpperCase());
            sc.nextLine();
            gerenciadorTarefas.adicionar(new Tarefa(descricao, prioridade));
            IO.println("Tarefa adicionada!\n");
            IO.print("Gostaria de adicionar outra (s/n)? ");
            opcao = sc.next().charAt(0);
            sc.nextLine();
        }

        IO.println("\n" + gerenciadorTarefas.total() + " tarefa(s) cadastrada(s).");
        IO.print("Gostaria de gerenciar suas tarefas (s/n)? ");
        opcao = sc.next().charAt(0);
        if (opcao == 's') {
            int opcaoGerenciador;
            do {
                IO.println("\n┌─────────────────────────────────┐");
                IO.println("│           MENU PRINCIPAL        │");
                IO.println("├─────────────────────────────────┤");
                IO.println("│  1 - Concluir tarefa            │");
                IO.println("│  2 - Listar pendentes           │");
                IO.println("│  3 - Filtrar por prioridade     │");
                IO.println("│  4 - Total de tarefas           │");
                IO.println("│  5 - Total de concluídas        │");
                IO.println("│  6 - Sair                       │");
                IO.println("└─────────────────────────────────┘");
                IO.print("Opção: ");
                opcaoGerenciador = sc.nextInt();
                IO.println("");

                switch (opcaoGerenciador) {
                    case 1:
                        IO.print("ID da tarefa que gostaria de marcar como concluída: ");
                        int idConcluida = sc.nextInt();
                        try {
                            gerenciadorTarefas.concluirTarefa(idConcluida);
                            IO.print("Tarefa marcada como concluída!");
                        } catch (IllegalArgumentException e) {
                            IO.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        IO.println("Tarefas pendentes:");
                        for (Tarefa tarefa : gerenciadorTarefas.listarPendentes()) {
                            IO.println(tarefa);
                        }
                        break;
                    case 3:
                        IO.print("Gostaria de filtrar por qual prioridade (baixa/media/alta)? ");
                        Prioridade prioridadeFiltro = Prioridade.valueOf(sc.next().toUpperCase());
                        IO.println("Tarefas filtradas por prioridade " + prioridadeFiltro.toString().toLowerCase() + ":");
                        for (Tarefa tarefa : gerenciadorTarefas.filtrarPorPrioridade(prioridadeFiltro)) {
                            IO.println(tarefa);
                        }
                        break;
                    case 4:
                        IO.println("Total de tarefas: " + gerenciadorTarefas.total());
                        break;
                    case 5:
                        IO.println("Total de tarefas concluídas: " + gerenciadorTarefas.totalConcluidas());
                        break;
                    case 6:
                        IO.println("Gerenciador encerrado!");
                        break;
                    default:
                        IO.println("Insira uma opção válida!");
                }
            } while (opcaoGerenciador != 6);
        } else {
            IO.println("Programa encerrado!");
        }

        sc.close();
    }
}
