package exercicio7;

import exercicio7.entities.Circulo;
import exercicio7.entities.Retangulo;
import exercicio7.entities.Triangulo;
import exercicio7.enums.Cor;
import exercicio7.interfaces.Forma;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Forma> listaFormas = new ArrayList<>();

        IO.print("Insira o número de formas que serão adicionadas: ");
        int numFormas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; numFormas > i; i++) {
            IO.print("\nQual será o tipo da forma #" + (i+1) + " (circulo/retangulo/triangulo)? " );
            String tipoDeForma = sc.nextLine().toLowerCase();
            if (tipoDeForma.equals("circulo") || tipoDeForma.equals("retangulo") || tipoDeForma.equals("triangulo")) {
                switch (tipoDeForma) {
                    case "circulo":
                        IO.print("Insira o raio do círculo: ");
                        double raio = sc.nextDouble();
                        sc.nextLine();
                        listaFormas.add(new Circulo(raio));
                        IO.println("Círculo adicionado com sucesso!");
                        break;
                    case "retangulo":
                        IO.print("Insira a largura do retângulo: ");
                        double largura = sc.nextDouble();
                        IO.print("Insira a altura do retângulo: ");
                        double altura = sc.nextDouble();
                        IO.print("Insira a cor do retângulo: ");
                        Cor cor = Cor.valueOf(sc.next().toUpperCase());
                        sc.nextLine();
                        listaFormas.add(new Retangulo(largura, altura, cor));
                        IO.println("Retângulo adicionado com sucesso!");
                        break;
                    case "triangulo":
                        IO.print("Insira o primeiro lado do triângulo: ");
                        double ladoUm = sc.nextDouble();
                        IO.print("Insira o segundo lado do triângulo: ");
                        double ladoDois = sc.nextDouble();
                        IO.print("Insira o terceiro lado do triângulo: ");
                        double ladoTres = sc.nextDouble();
                        sc.nextLine();
                        listaFormas.add(new Triangulo(ladoUm, ladoDois, ladoTres));
                        IO.println("Triângulo adicionado com sucesso!");
                        break;
                }
            } else {
                IO.println("Insira um tipo válido de forma!");
                i--;
            }
        }

        IO.println("\nFormas registradas: ");
        for (Forma forma : listaFormas) {
            IO.println(forma.descricao());
            if (forma instanceof Retangulo r) {
                IO.println("Cor do retângulo: " + r.getColor().toString().toLowerCase());
            }
        }

        double areaTotal = listaFormas.stream()
                .map(Forma::area)
                .reduce(0.0, (acumulador, area) -> acumulador + area);
        IO.println("\nÁrea total: " + String.format("%.2f", areaTotal));
    }
}
