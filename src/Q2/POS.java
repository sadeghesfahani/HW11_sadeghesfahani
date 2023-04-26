package Q2;

class POS extends Thread {
    private final BankAccount bankAccount;

    public POS(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            bankAccount.withdraw(10);
        }
    }
}
