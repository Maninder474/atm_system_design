package WithdrawalStrategy;

import ValueObjects.ATM;

public abstract class CashWithdrawal {
    CashWithdrawal nexCashWithdrawalProcessor;

    CashWithdrawal(CashWithdrawal cashWithdrawal){
        this.nexCashWithdrawalProcessor = cashWithdrawal;
    }

    public void withdraw(ATM atm,Long remainingAmount){
        if(nexCashWithdrawalProcessor!=null){
            System.out.println("going to the next process");
            nexCashWithdrawalProcessor.withdraw(atm,remainingAmount);
        }
    }
}
