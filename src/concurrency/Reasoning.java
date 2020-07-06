package concurrency;

class Reasoning extends Thread {
    //set up this class so it can become a valid thread. 
    void distinguish() {
        System.out.println("Any program that in execution is called a process while a part of that process is called a segment.");
        System.out.println("The start method executes the current thread while the run methods executes a new threat.");
    }

    @Override
    public void run() {
        distinguish();
    }
}

