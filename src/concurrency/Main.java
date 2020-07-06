package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.

         Thread Reasoning = new Reasoning();
         Reasoning.start();

         TeamTC1 tc1 = new TeamTC1();
         Thread Team = new Thread(tc1);
         Team.setName("Code Connoisseurs");
         Team.start();
    }
}