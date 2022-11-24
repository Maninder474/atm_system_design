package AtmStates;

import ValueObjects.ATM;
import ValueObjects.Card;
import ValueObjects.TransactionType;

public abstract class AtmState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        System.out.println("OOPS!! Something went wrong ub select operation");
    }

    public void cashWithdrawal(ATM atm, Card card, Long withdrawAmount){
        System.out.println("OOPS!! Something went wrong in cashWIthdrawal");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard(){
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(ATM atm){
        System.out.println("OOPS!! Something went wrong");
    }

}
