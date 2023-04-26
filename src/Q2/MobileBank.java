package Q2;

class MobileBank extends Thread {
    private final BankAccount bankAccount;

    public MobileBank(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Balance: " + bankAccount.getBalance());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
