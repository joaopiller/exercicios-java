package exercicio7.entities;

import exercicio7.enums.Cor;
import exercicio7.interfaces.Colorida;
import exercicio7.interfaces.Forma;

public class Retangulo implements Forma, Colorida {
    private double largura, altura;
    private Cor cor;

    public Retangulo(double largura, double altura, Cor cor) {
        this.largura = largura;
        this.altura = altura;
        this.cor = cor;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double area() {
        return largura * altura;
    }

    @Override
    public double perimetro() {
        return 2 * altura + 2 * largura;
    }

    @Override
    public Cor getColor() {
        return cor;
    }
}
