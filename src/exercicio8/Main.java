package exercicio8;

import exercicio8.entities.CarRental;
import exercicio8.entities.Vehicle;
import exercicio8.services.BrazilTaxService;
import exercicio8.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel:");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();

        System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);

        System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Preço por hora: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("Preço por dia: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        System.out.println("FATURA:");
        System.out.println("Pagamento básico: R$" + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Imposto: R$" + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Pagamento total: R$" + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

        sc.close();
    }
}