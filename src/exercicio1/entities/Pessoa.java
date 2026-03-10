package exercicio1.entities;

public class Pessoa {
    private String nome;
    private Double altura;
    private Double peso;

    public Pessoa(String nome, Double altura, Double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public Double imc() {
        return peso / Math.pow(altura, 2);
    }

    public String classificacao() {
        Double imc = imc();
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }

    @Override
    public String toString() {
        return nome + " | IMC: " + String.format("%.2f", imc()) + " | " + classificacao();
    }
}
