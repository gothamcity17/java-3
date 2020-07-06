package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class TeamTC1 implements Runnable {

    List<String> team = new ArrayList<>();

    @Override
    public void run() {    
    String[] myTeam = new String[]{"Mark", "Aaron", "Caleb", "Cody", "Gowtham", "John", "Justin", "Kevin", "Korey", "Matthew", "Sarah", "Tyler", "Zach"};

    try { 
        for (int i = 0; i < myTeam.length; i++) {
        System.out.println(myTeam[i]);
        Thread.sleep(1000);
        team.add(myTeam[i]);
        }
        System.out.println(team);
    } catch (InterruptedException e) {
        System.out.println("Exception");
    }
}
    //This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.  In the run method of this thread, print out the name of each student in your TA group, (starting with your TA).  There should be a pause of 1 second before each name is printed to the console.The name should then be pushed to the team List  After all the names have been pushed to this List, print out the entire list of all the students in your TA group. Don't forget your TA as well!  All of these steps should be done whenever the thread is started.  (i.e. it can be done directly in the run()method of the thread itself).  Kick off the thread in the Main class of the concurrency package.  
}