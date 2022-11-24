package AtmStates;

import ValueObjects.ATM;
import ValueObjects.Card;
import WithdrawalStrategy.CashWithdrawal;
import WithdrawalStrategy.FiveHundredProcessor;
import WithdrawalStrategy.HundredProcessor;
import WithdrawalStrategy.TwoThousandProcessor;

public class withdrawalState extends AtmState{
    @Override
    public void cashWithdrawal(ATM atmObject, Card card, Long withdrawalAmountRequest) {

        if (atmObject.getBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {

            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.deductATMBalance(withdrawalAmountRequest);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawal withdrawProcessor =
                    new TwoThousandProcessor(new FiveHundredProcessor(new HundredProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            exit(atmObject);
        }
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new idleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

}
