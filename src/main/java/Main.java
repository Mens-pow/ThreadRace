public class Main implements ThreadCallback {
    private MyThread firstThread;    //First thread
    private MyThread secondThread;    //Second thread

    private String firstThreadName = "Поток А";
    private String secondThreadName = "Поток Б";

    private volatile boolean complete;

    public static void main(String[] args) {
        Main main = new Main();

        main.firstThread = new MyThread(main.firstThreadName, main);    //Create first thread
        main.secondThread = new MyThread(main.secondThreadName, main);    //Create second thread

        main.startRace(); //start race
    }

    private void startRace() {
        firstThread.start();
        secondThread.start();
    }

    public synchronized void complete(String name) {
        if (!complete) { //If another thread is alive
            complete = true; 
            LogManager.write(name + " " + "выиграл");
        } else {
            LogManager.write(name + " " + "проиграл");
        }

    }
}