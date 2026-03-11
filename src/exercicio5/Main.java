package exercicio5;

import exercicio5.entities.Aluno;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Aluno> listaAlunos = new ArrayList<>();
        int numNotas = 5;

        IO.print("Insira o número de alunos da classe: ");
        int numAlunos = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numAlunos; i++) {
            IO.println("\nAluno #" + (i+1) + ":");
            while (true) {
                try {
                    IO.print("Insira o nome do aluno: ");
                    String nome = sc.nextLine();

                    IO.print("Insira a matrícula do aluno: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();

                    listaAlunos.add(new Aluno(nome, matricula));
                    break;
                } catch (IllegalArgumentException e) {
                    IO.println("Error: " + e.getMessage());
                } catch (InputMismatchException e) {
                    IO.println("Error: Formato inválido. Digite um número inteiro.");
                    sc.nextLine();
                }
            }

            IO.println("Notas de " + listaAlunos.get(i).getNome() + ":");

            for (int j = 0; j < numNotas; j++) {
                while (true) {
                    try {
                        IO.print("Nota " + (j+1) + ": ");
                        double nota = sc.nextDouble();
                        sc.nextLine();

                        listaAlunos.get(i).lancarNota(j, nota);
                        break;
                    } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                        IO.println("Error: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        IO.println("Error: Formato inválido. Digite um número válido (ex: 7.5).");
                        sc.nextLine();
                    }
                }
            }
        }

        IO.println("\nAlunos ordenados por média:");
        listaAlunos.stream().sorted(Comparator.comparingDouble(Aluno::media).reversed()).forEach(IO::println);
        sc.close();
    }
}