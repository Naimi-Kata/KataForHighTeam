package controller;

import model.Operation;
import service.PrintingService;
import service.OperationService;
import util.OperationType;


import java.util.*;

public class AppManager {

    List<Operation> listeOperations = new ArrayList<Operation>();

    PrintingService printingService = new PrintingService();
    OperationService operationService =new OperationService();

    public void manageApp() {
        int userResponse = printingService.printingMenu();
        switch (userResponse){
            case 1:listeOperations = operationService.proceedDeposit(OperationType.DEPOSIT,  listeOperations);
                manageApp();
                break;
            case 2:listeOperations = operationService.proceedWithdrawal(OperationType.WITHDRAWAL, listeOperations) ;
                manageApp();
                break;
            case 3: printingService.printingHistory(listeOperations);
                manageApp();
                break;
            default:
                break;
        }

    }


}

