package Q1;

import java.util.ArrayList;

public class SharedList {
    private final ArrayList<Integer> list = new ArrayList<>();
    private boolean isOddThreadTurn = false;
    public synchronized void addEven(int evenNumber) throws InterruptedException {
        if (isOddThreadTurn) {
            wait();
        }
        list.add(evenNumber);
        isOddThreadTurn = true;
        notify();
    }
    public synchronized void addOdd(int oddNumber) throws InterruptedException {
        if (!isOddThreadTurn) {
            wait();
        }
        list.add(oddNumber);
        isOddThreadTurn = false;
        notify();
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}
