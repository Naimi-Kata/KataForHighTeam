package model;

import util.OperationType;

import java.math.BigDecimal;
import java.util.Date;

public  class Operation {

    public Operation(OperationType operationType, Date date, BigDecimal amount, BigDecimal balance) {
        this.id = id;
        this.operationType = operationType;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    private int id;

    private OperationType operationType;

    private Date date;


    private BigDecimal amount;


    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
