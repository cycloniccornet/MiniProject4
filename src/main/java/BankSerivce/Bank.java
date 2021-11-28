package BankSerivce;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;


//Java delicate allows us to acces the class from the camunda engine
@Named //Named allows us to call the class name without calling the package name
public class Bank implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String fullname = "";
        String income = "0.0";
        String loanAmount = "0.0";

        Double bankInterest = 0.0;
        Double bankLoan = 0.0;

        fullname = (String) delegateExecution.getVariable("fullname"); //Laves til string da Camunda sender object
        income = (String) delegateExecution.getVariable("income");
        loanAmount = (String) delegateExecution.getVariable("loan");

        double incomeDouble = Double.parseDouble(income);
        double loanAmountDouble = Double.parseDouble(loanAmount);

        if (loanAmountDouble <= 10000) {
            bankLoan = loanAmountDouble * 5;
            bankInterest = 10.00;
        } else if (loanAmountDouble <= 100000) {
            bankLoan = loanAmountDouble * 10;
            bankInterest = 7.50;
        } else if (loanAmountDouble <= 123456789) {
            bankLoan = loanAmountDouble * 15;
            bankInterest = 5.00;
        } else {
            System.out.println("Throwing contract error");
            bankLoan = 0.0;
            bankInterest = 0.0;
            throw new BpmnError("Contract_Error", "Something went wrong Try applying again and dont break my code this time.");
        }

        System.out.println("This is the bank offer: " + bankInterest + " " + bankLoan);
        delegateExecution.setVariable("bankLoan", bankLoan);
        delegateExecution.setVariable("bankInterest", bankInterest);
    }
}
