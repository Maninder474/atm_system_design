package WithdrawalStrategy;

import ValueObjects.ATM;

public class TwoThousandProcessor extends CashWithdrawal{

    public TwoThousandProcessor(CashWithdrawal fiveHundredWithdrawProcessor) {
        super(fiveHundredWithdrawProcessor);
    }
    @Override
    public void withdraw(ATM atm, Long remainingAmount){
        System.out.println("in two thousand rupees withdraw");
        Long required =  remainingAmount/2000L;
        Long balance = remainingAmount%2000L;

        if(required <= atm.getTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        }
        else if(required > atm.getTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getTwoThousandNotes());
            balance = balance + (required-atm.getTwoThousandNotes()) * 2000;
        }
        System.out.println("balance "+balance);
        if(balance != 0){
            super.withdraw(atm, balance);
        }

    }
    
}
