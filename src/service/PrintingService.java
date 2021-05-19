package service;

import model.Operation;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;


public class PrintingService {

    public int printingMenu(){
        System.out.println("### bienvenu sur votre interface bancaire ###");
        System.out.println("quelle opération souhaitez-vous realiser ?");
        System.out.println("1- dépot");
        System.out.println("2- retrait");
        System.out.println("3- afficher l'historique des opérations");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void printingHistory(List<Operation> listeOperations){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("DD/MM/YYYY");

        System.out.println(String.format("|%30s|","operation ")+
                String.format("|%30s|","date ")+
                String.format("|%30s|","montant")+
                String.format("|%30s|","solde "));

        for (Operation operation:listeOperations) {
            System.out.println(String.format("|%30s|",operation.getOperationType())+
                    String.format("|%30s|",dateFormatter.format(operation.getDate()))+
                    String.format("|%30s|",operation.getAmount())+
                    String.format("|%30s|",operation.getBalance()));
        }

    }
}
