package exercicio9;

import exercicio9.entities.Contract;
import exercicio9.entities.Installment;
import exercicio9.services.ContractService;
import exercicio9.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        IO.println("Entre com os dados do contrato:");
        IO.print("Número: ");
        int contractNum = sc.nextInt();
        IO.print("Data (dd/mm/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), dtf);
        IO.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(contractNum, contractDate, contractValue);

        IO.print("Entre com o número de parcelas: ");
        int months = sc.nextInt();
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, months);

        IO.println("Parcelas:");
        contract.getInstallmentsList().forEach(IO::println);
    }
}
