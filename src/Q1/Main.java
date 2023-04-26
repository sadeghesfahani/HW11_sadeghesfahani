package Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        while(input<0) {
            System.out.print("Enter a positive number: ");
            input = scanner.nextInt();
        }

        SharedList sharedList = new SharedList();
        Thread evenThread = new EvenThread(input, sharedList);
        Thread oddThread = new OddThread(input, sharedList);

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Result: " + sharedList.getList());
    }

}