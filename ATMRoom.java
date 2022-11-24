import AtmStates.AtmState;
import ValueObjects.ATM;
import ValueObjects.BankAccount;
import ValueObjects.Card;
import ValueObjects.TransactionType;
import ValueObjects.User;

public class ATMRoom {
    
    ATM atm;
    User user;
    public static void main(String[] args) {
        ATMRoom atmRoom= new ATMRoom();
        atmRoom.initialize();


        atmRoom.atm.printCurrentATMStatus();
        // checking balance 
        ((AtmState) atmRoom.atm.getCurrentATMState()).insertCard(atmRoom.atm, atmRoom.user.card);
        ((AtmState) atmRoom.atm.getCurrentATMState()).authenticatePin(atmRoom.atm, atmRoom.user.card, 123);
        ((AtmState) atmRoom.atm.getCurrentATMState()).selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.BALANCE_CHECK);
        ((AtmState) atmRoom.atm.getCurrentATMState()).displayBalance(atmRoom.atm, atmRoom.user.card);     
        
        //cash withdrawal
        ((AtmState) atmRoom.atm.getCurrentATMState()).insertCard(atmRoom.atm, atmRoom.user.card);
        ((AtmState) atmRoom.atm.getCurrentATMState()).authenticatePin(atmRoom.atm, atmRoom.user.card, 123);
        ((AtmState) atmRoom.atm.getCurrentATMState()).selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        ((AtmState) atmRoom.atm.getCurrentATMState()).cashWithdrawal(atmRoom.atm, atmRoom.user.card, 2700L);
        
        atmRoom.atm.printCurrentATMStatus();

    }
    private void initialize(){
        atm = ATM.getATMObject();
        atm.setAtmBalance(3500l, 1l,2l,5l);

        user = getUser();
    }
    private User getUser() {
        User user = new User();
        user.setBankAccount(getBankAccount());
        user.setCard(getCard());
        return user;
    }

    private Card getCard() {
        Card card = new Card(123, getBankAccount(),123, "Maninder");
        return card;
    }

    private BankAccount getBankAccount() {
        BankAccount bankAccount = new BankAccount(5000L);
        return bankAccount;
    }
}
