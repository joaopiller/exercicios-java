package exercicio7.interfaces;

public interface Forma {
    double area();
    double perimetro();

    default String descricao() {
        return getClass().getSimpleName() + " | Área: " + String.format("%.2f", area()) + " | Perímetro: " + String.format("%.2f", perimetro());
    }
}
