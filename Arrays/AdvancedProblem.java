package Arrays;
public class AdvancedProblem {


    // stock profit;
    public static void stockProfit(int array[]){
        int maxProfit = 0;
        int minPrice = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i]>minPrice){
                int profit = array[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                minPrice = array[i];
            }
        }
        System.out.println(maxProfit);
    }


    // Trapping Rainwater problem 
    public static void trapRainWater(int array[]){
        int vol = 0;

        // for(int i=1; i<array.length-1; i++){
        //     int mr = Integer.MIN_VALUE;
        //     int ml = Integer.MIN_VALUE;
        //     for(int j=i; j<array.length; j++){
        //         int r = array[j];
        //         mr = Math.max(r,mr);
        //     }
        //     for(int j=i; j>=0; j--){
        //         int l = array[j];
        //         ml = Math.max(l,ml);
        //     }
        //     if(array[i]>=ml || array[i]>=mr){
        //         continue;
        //     }
        //     int waterLevel = Math.min(mr,ml)-array[i];
        //     vol+=waterLevel;
        // }


        /// calculatin left max boundary for every element;
        int ml[] = new int[array.length];
        ml[0] = array[0];
        for(int i=1; i<ml.length; i++){
            ml[i] = Math.max(array[i],ml[i-1]);
        }


        // calculating right max boundary for every element
        int mr[] = new int[array.length];
        mr[array.length-1] = array[array.length-1];
        for(int i=array.length-2; i>=0; i--){
            mr[i] = Math.max(array[i],mr[i+1]);
        }

        // calculating volume of the water trapped;
        for(int i=0; i<array.length; i++){
            int waterLevel = Math.min(mr[i],ml[i]) - array[i];
            vol+=waterLevel;
        }

        System.out.println(vol);
    }
    public static void main(String arg[]){

        // trapped water
        int height[] = {4,2,0,6,3,2,5};
        trapRainWater(height);


        // stock profit
        int prices[] = {7,1,5,3,6,4};
        stockProfit(prices);
    }
}
