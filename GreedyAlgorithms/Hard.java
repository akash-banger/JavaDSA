package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class Hard {

    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int deadline, int profit, int id){
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }

    public static void main(String arg[]){

        // job sequencing problem 
        int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new Job(jobsInfo[i][0], jobsInfo[i][1], i));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);  //descending order

        ArrayList<Integer> ans = new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                ans.add(curr.id);
                time++;
            }
        }
        System.out.println(ans);



    }
}
