package AtmStates;

import ValueObjects.ATM;
import ValueObjects.Card;
import ValueObjects.TransactionType;

public class selectOperationState extends AtmState{
    public selectOperationState(){
        showOperations();
    }

    @Override
    public void selectOperation(ATM atmObject, Card card, TransactionType txnType){

        switch (txnType) {

            case CASH_WITHDRAWAL:
                atmObject.setCurrentATMState(new withdrawalState());
                break;
            case BALANCE_CHECK:
                atmObject.setCurrentATMState(new checkBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atmObject);
            }

        }
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

    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }

}
