package ValueObjects;

import AtmStates.AtmState;
import AtmStates.idleState;

public class ATM{
    
    private Long balance;
    private Long HundredNotes;
    private Long fiveHundredNotes;
    private Long twoThousandNotes;

    AtmState currentATMState;
    private static ATM atmObject = new ATM();

    ATM(){

    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getHundredNotes() {
        return HundredNotes;
    }

    public void setHundredNotes(Long hundredNotes) {
        HundredNotes = hundredNotes;
    }

    public Long getFiveHundredNotes() {
        return fiveHundredNotes;
    }

    public void setFiveHundredNotes(Long fiveHundredNotes) {
        this.fiveHundredNotes = fiveHundredNotes;
    }

    public Long getTwoThousandNotes() {
        return twoThousandNotes;
    }

    public void setTwoThousandNotes(Long twoThousandNotes) {
        this.twoThousandNotes = twoThousandNotes;
    }

    public boolean IsAmountAvailable(Long amount){
        if(amount<balance)
            return true;
        return false;
    }

    public void deductFiveHundredNotes(Long required) {
        this.fiveHundredNotes = this.fiveHundredNotes - required;
    }
    public void deductHundredNotes(Long required) {
        this.HundredNotes = this.HundredNotes - required;
    }
    public void deductTwoThousandNotes(Long required) {
        this.twoThousandNotes = this.twoThousandNotes - required;
    }

    public void setCurrentATMState(AtmState atmState) {
        this.currentATMState = atmState;
    }

    public void deductATMBalance(Long withdrawalAmountRequest) {
        this.balance = this.balance - withdrawalAmountRequest;
    }

    public void setAtmBalance(Long atmBalance, Long twoK, Long fiveH, Long h) {
        this.balance = atmBalance;
        this.twoThousandNotes = twoK;
        this.fiveHundredNotes = fiveH;
        this.HundredNotes = h;

    }

    public static ATM getATMObject() {
         atmObject.setCurrentATMState(new idleState());
         return atmObject;
    }

    public void printCurrentATMStatus() {
        System.out.println("Balance: " + balance);
        System.out.println("2kNotes: " + twoThousandNotes);
        System.out.println("500Notes: " + fiveHundredNotes);
        System.out.println("100Notes: " + HundredNotes);

    }

    public Object getCurrentATMState() {
        return currentATMState;
    }
    

}