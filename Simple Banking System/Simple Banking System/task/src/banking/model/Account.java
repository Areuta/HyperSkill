package banking.model;

public class Account {
    private long id;
    private String cardNumber;
    private String pin;
    private long balance;

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


    public Account(String cardNumber) {
        this.cardNumber = cardNumber;
        this.pin = AccountUtils.pinGenerator();
        this.balance = 0;
    }

    public Account(String cardNumber, String pin, long balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }


    @Override
    public String toString() {
        return String.format("%n%d. %s %s %d",
                getId(), getCardNumber(), getPin(), getBalance());
    }
}
