package Q1;

class OddThread extends Thread {
    private final int input;
    private final SharedList sharedList;

    public OddThread(int input, SharedList sharedList) {
        this.input = input;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i = 1; i <= input; i += 2) {
            try {
                sharedList.addOdd(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}