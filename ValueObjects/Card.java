package ValueObjects;
public class Card {
    private int pin;
    private BankAccount bankAccount;
    private int cvv;
    private String holderName;
    
    public Card(int pin, BankAccount bankAccount, int cvv, String holderName) {
        this.pin = pin;
        this.bankAccount = bankAccount;
        this.cvv = cvv;
        this.holderName = holderName;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public BankAccount getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public boolean isCorrectPINEntered(int pin2) {
        if(pin == pin2)
            return true;
        return false;
    }
    public Long getBalance(){
        return this.bankAccount.getBalance();
    }
    public void deductBankBalance(Long withdrawalAmountRequest) {
        this.getBankAccount().deduceBalance(withdrawalAmountRequest);
    }

}
