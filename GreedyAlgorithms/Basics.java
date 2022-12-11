package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Basics {

    /* Greedy Algorithm
     * It is a problem solving technique where we make the locally optimum choice at 
     * each stage & hope to achieve a global optimum;
     */

    // 1st Problem 
    // Activity Selection
    public static int maxActivities(int start[], int end[], ArrayList<Integer> list){
        int count = 1;
        int lastActivity = 0;
        list.add(lastActivity);
        for(int i=1; i<end.length; i++){
            if(start[i] >= end[lastActivity]){
                lastActivity = i;
                list.add(lastActivity);
                count++;
            }
        }
        return count;
    }

    // sorting activities along the endtime 
    public static void sortActivites(int start[], int end[]){
        int activities[][] = new int[start.length][2];
        for(int i=0; i<start.length; i++){
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }

        // lamda function => short form
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[1])); // sorts with respect to 2nd coloumn

        for(int i=0; i<start.length; i++){
            start[i] = activities[i][0];
            end[i] = activities[i][1];
        }

    }



    // Fractional Knapsack 
    // knapsack is a bag in which we place things
    // given n items with their weights and values 
    // we have to place items in knapsack such that the total value is maximum 
    // you can take the fraction weight of an item also
    public static int fractionalKnapsack(int values[], int weight[],int w){
        double ratio[] = new double[values.length];
        for(int i=0; i<ratio.length; i++){
            ratio[i] = values[i]/(double)weight[i];
        }
        
        double matrix[][] = new double[ratio.length][3];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrix[i][0] = values[i];
                matrix[i][1] = weight[i];
                matrix[i][2] = ratio[i];
            }
        }

        Arrays.sort(matrix, Comparator.comparingDouble(o -> o[2]));

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                values[i] = (int)matrix[i][0];
                weight[i] = (int)matrix[i][1];
                ratio[i] = matrix[i][2];
            }
        }
        int totalValue = 0;
        int i = values.length-1;
        while(w>0){
            if(weight[i]<=w){
                w-= weight[i];
                totalValue+= values[i];
            }else{
                totalValue+= ratio[i]*w;
                break;
            }
            i--;
        }

        return totalValue;
    }   


    // absolute pair difference  
    public static int absoluteDifferencePair(int a[], int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int pairtDifference = 0;
        for(int i=0; i<a.length; i++){
            pairtDifference+= Math.abs(a[i] - b[i]);
        }
        return pairtDifference;
    }


    public static void main(String arg[]){
        ArrayList<Integer> list = new ArrayList<>();
        int start[] = {3,1,0,8,5,5};
        int end[] = {4,2,6,9,7,9};

        // if endtime is not sorted than we have to sort It

        sortActivites(start, end);

        // for sorting 

        System.out.println(maxActivities(start, end, list));
        System.out.println(list);



        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int w = 50;
        System.out.println(fractionalKnapsack(val, weight, w));


        int a[] = {1,2,3};
        int b[] = {2,1,3};

        System.out.println(absoluteDifferencePair(a, b));
    }
}
