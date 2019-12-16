class MyThread extends Thread
{

    private ThreadCallback threadCallback;
    private int count = 0;
    private String name;

    MyThread(String name, ThreadCallback threadCallback){
        this.name = name;
        this.threadCallback = threadCallback;
    }

    @Override
    public void run()
    {
        while (count<100) {
            LogManager.write(name + ": "+ ++count);
        }
            threadCallback.complete(name);
    }
}