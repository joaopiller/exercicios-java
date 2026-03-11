package exercicio5.entities;

import java.util.Arrays;

public class Aluno {
    private String nome;
    private int matricula;
    private double[] notas = new double[5];

    public Aluno(String nome, int matricula) {
        if (matricula <= 0) {
            throw new IllegalArgumentException("A matrícula deve ser um número maior que zero");
        }
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if (matricula <= 0) {
            throw new IllegalArgumentException("Matrícula deve ser um número maior que zero");
        }
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void lancarNota(int posicao, double nota) {
        if (posicao < 0 || posicao > 4) {
            throw new ArrayIndexOutOfBoundsException("Posição deve ser entre 0 e 4");
        }
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        notas[posicao] = nota;
    }

    public double media() {
        return Arrays.stream(notas).average().orElse(0.0);
    }

    public double maiorNota() {
        return Arrays.stream(notas).max().orElse(0.0);
    }

    public String situacao() {
        double media = media();
        if (media >= 7) {
            return "Aprovado";
        } else if (media >= 5) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    @Override
    public String toString() {
        return nome + " | Maior nota: " + String.format("%.1f", maiorNota()) + " | Média: " + String.format("%.1f", media()) + " | Situação: " + situacao();
    }
}
