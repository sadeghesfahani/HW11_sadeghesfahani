package Q2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class BankAccount {
    private double balance;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {

        lock.writeLock().lock();
        try {
            balance += amount;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void withdraw(double amount) {
        if (amount >= balance) {
            lock.writeLock().lock();
            try {
                balance -= amount;
            } finally {
                lock.writeLock().unlock();
            }
        }else{
            System.out.println("Not enough balance");
        }
    }

    public double getBalance() {
        lock.readLock().lock();
        try {
            return balance;
        } finally {
            lock.readLock().unlock();
        }
    }
}