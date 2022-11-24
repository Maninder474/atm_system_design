package AtmStates;

import ValueObjects.ATM;
import ValueObjects.Card;

public class checkBalanceState extends AtmState{
    public checkBalanceState() {
    }

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your Balance is: " + card.getBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atmObject){
        returnCard();
        atmObject.setCurrentATMState(new idleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }

}
