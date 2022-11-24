package AtmStates;


import ValueObjects.ATM;
import ValueObjects.Card;

public class idleState extends AtmState{

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
    
}
