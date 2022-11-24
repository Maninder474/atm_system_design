package WithdrawalStrategy;

import ValueObjects.ATM;

public class HundredProcessor extends CashWithdrawal{

    public HundredProcessor(CashWithdrawal cashWithdrawal) {
        super(cashWithdrawal);
    }

    @Override
    public void withdraw(ATM atm, Long remainingAmount){
        System.out.println("in hundred rupee withdraw");
        Long required =  remainingAmount/100L;
        Long balance = remainingAmount%100L;

        if(required <= atm.getHundredNotes()) {
            atm.deductHundredNotes(required);
        }
        else if(required > atm.getHundredNotes()) {
            atm.deductHundredNotes(atm.getHundredNotes());
            balance = balance + (required-atm.getHundredNotes()) * 100;
        }
        System.out.println("balance "+balance);
        if(balance != 0){
            super.withdraw(atm, balance);
        }

    }
}
