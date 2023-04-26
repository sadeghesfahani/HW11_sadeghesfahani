package Q2;

class ATM extends Thread {
    private final BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            bankAccount.deposit(5);
        }
    }
}
