package exercicio6.entities;

public class Gerente extends FuncionarioCLT {
    private double bonusGerencia;

    public Gerente(String nome, String cpf, double salarioBase, double bonusGerencia) {
        super(nome, cpf, salarioBase);
        this.bonusGerencia = bonusGerencia;
    }

    public double getBonusGerencia() {
        return bonusGerencia;
    }

    public void setBonusGerencia(double bonusGerencia) {
        this.bonusGerencia = bonusGerencia;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bonusGerencia;
    }
}
