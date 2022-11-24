package ValueObjects;

public class BankAccount {
    Long balance;

    public Long getBalance() {
        return balance;
    }

    public BankAccount(Long balance) {
        this.balance = balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void deduceBalance(Long amount){
        this.balance = this.balance - amount;
    }
}
