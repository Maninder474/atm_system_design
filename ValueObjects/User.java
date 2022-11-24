package ValueObjects;
public class User {
    private BankAccount bankAccount;
    public Card card;
    private String firstName;
    private String LastName;
    
    public User() {
        
    }

    public User(BankAccount bankAccount, Card card, String firstName, String lastName) {
        this.bankAccount = bankAccount;
        this.card = card;
        this.firstName = firstName;
        LastName = lastName;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

}
