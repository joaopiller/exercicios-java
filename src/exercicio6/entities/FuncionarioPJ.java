package exercicio6.entities;

public class FuncionarioPJ extends Funcionario {
    public FuncionarioPJ(String nome, String cpf, double salarioBase) {
        super(nome, cpf, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase - (salarioBase * 0.11);
    }
}
