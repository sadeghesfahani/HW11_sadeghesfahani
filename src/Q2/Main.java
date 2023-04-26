package Q2;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(0);

        Thread atm = new ATM(bankAccount);
        Thread pos = new POS(bankAccount);
        Thread mobileBank1 = new MobileBank(bankAccount);
        Thread mobileBank2 = new MobileBank(bankAccount);

        atm.start();
        pos.start();
        mobileBank1.start();
        mobileBank2.start();

        try {
            atm.join();
            pos.join();
            mobileBank1.join();
            mobileBank2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
