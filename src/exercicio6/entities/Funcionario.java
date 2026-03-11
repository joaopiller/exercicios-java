package exercicio6.entities;

import exercicio6.exceptions.CpfInvalidoException;

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salarioBase;

    public Funcionario(String nome, String cpf, double salarioBase) {
        if (!cpf.matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")) {
            throw new CpfInvalidoException("Insira um CPF válido");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public String toString() {
        String tipo = "";
        if (this instanceof Gerente) {
            tipo = "gerente";
        } else if (this instanceof FuncionarioCLT) {
            tipo = "CLT";
        } else if (this instanceof FuncionarioPJ) {
            tipo = "PJ";
        }

        return nome + ", tipo de funcionário: " + tipo + ", CPF: " + cpf + ", salário: " + String.format("%.2f", calcularSalario());
    }
}
