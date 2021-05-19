package service;

import exception.NotEnoughtMoneyException;
import model.Operation;
import util.OperationType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OperationService {


    public List<Operation> proceedDeposit(OperationType deposit, List<Operation> listeOperations) {
        System.out.println("Saisissez le montant du dépot");
        Scanner sc = new Scanner(System.in);
        BigDecimal amount = new BigDecimal(sc.nextInt());
        if(!listeOperations.isEmpty()){
            Operation LastOperation = listeOperations.get(listeOperations.size()-1);
            Operation operation = new Operation(deposit,new Date(),amount,LastOperation.getBalance().add(amount));
            listeOperations.add(operation);
            return listeOperations;
        }
        Operation operation = new Operation(deposit,new Date(),amount,amount);
        listeOperations.add(operation);
        return listeOperations;
    }

    public List<Operation> proceedWithdrawal(OperationType withdrawal,List<Operation> listeOperations)  {

        System.out.println("Saisissez le montant du retrait");
        Scanner sc = new Scanner(System.in);
        BigDecimal amount = new BigDecimal(sc.nextInt());
        Operation LastOperation = listeOperations.get(listeOperations.size()-1);
        try {
            if(LastOperation.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0)
             throw new NotEnoughtMoneyException("!!!!!!!!!! attention, le solde est insuffisant, vous serez à decouvert");

        } catch (NotEnoughtMoneyException e) {
            System.out.println(e.getMessage());
        }finally {
            Operation operation = new Operation(withdrawal,new Date(),amount,LastOperation.getBalance().subtract(amount));
            listeOperations.add(operation);
        }
            return listeOperations;

    }
}
