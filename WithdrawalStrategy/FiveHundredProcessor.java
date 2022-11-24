package WithdrawalStrategy;

import ValueObjects.ATM;

public class FiveHundredProcessor extends CashWithdrawal{

    public FiveHundredProcessor(CashWithdrawal cashWithdrawal) {
        super(cashWithdrawal);
    }

    @Override
    public void withdraw(ATM atm, Long remainingAmount){
        System.out.println("in five hundred rupee withdraw");
        Long required =  remainingAmount/500L;
        Long balance = remainingAmount%500L;

        if(required <= atm.getFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        }
        else if(required > atm.getFiveHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getFiveHundredNotes());
            balance = balance + (required-atm.getFiveHundredNotes()) * 500;
        }
        System.out.println("balance "+balance);
        if(balance != 0){
            super.withdraw(atm, balance);
        }

    }
    
}
