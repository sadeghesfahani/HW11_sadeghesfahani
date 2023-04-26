package Q1;

class EvenThread extends Thread {
    private final int input;
    private final SharedList sharedList;

    public EvenThread(int input, SharedList sharedList) {
        this.input = input;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i = 0; i <= input; i += 2) {
            try {
                sharedList.addEven(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}