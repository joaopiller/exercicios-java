package exercicio9.services;

import exercicio9.entities.Contract;
import exercicio9.entities.Installment;
import exercicio9.interfaces.OnlinePaymentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicValue = contract.getTotalValue() / months;
        List<Installment> installmentList = new ArrayList<>();
        for (int i = 0; months > i; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double amount = onlinePaymentService.interest(basicValue, i + 1);
            amount = onlinePaymentService.paymentFee(amount);
            installmentList.add(new Installment(dueDate, amount));
        }
        contract.setInstallmentsList(installmentList);
    }
}
