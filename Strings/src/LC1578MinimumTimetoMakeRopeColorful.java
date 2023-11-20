public class LC1578MinimumTimetoMakeRopeColorful {
    //In this problem we have to arrange balloons in such a way that there are no consecutive balloon.
    //We can remove consecutive balloon with less needed time.
    //Link : https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/

    public int minCost(String colors, int[] neededTime) {

        int totalTime = 0 ;
        for(int i =1 ;i <= colors.length() - 1 ; i ++){ // We are iterating through colors and starting from index 1 and not 0
            char c1 = colors.charAt(i - 1); // previous color
            char c2 = colors.charAt(i);  // current color

            if(c1 == c2){ // If there are two consecutive balloon color, then we will check the time
                if(neededTime[i-1] > neededTime[i]){ // If previous balloons time is greater than next balloons time
                    totalTime = totalTime + neededTime[i]; //
                    neededTime [i] = neededTime[i - 1]; // // The reason we are replacing  i to i-1 is if we remove that ith position, then for i+1
                    //position in next iteration should compare with i -1, and we that value to compare

                }
                //If the time needed for the current color is greater than or equal to the time needed for the previous color, then it adds the time needed for the
                //previous color to the total time and sets the time needed for the previous color to 0.

                else{
                    totalTime = totalTime + neededTime[i - 1];
                    neededTime[i - 1] = 0 ;
                }

            }

        }
        return totalTime ;
    }
}
