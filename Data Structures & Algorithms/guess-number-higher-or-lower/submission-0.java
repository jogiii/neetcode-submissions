/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        //beacuse problem start with 1 to n
        int left = 1;
        int right = n;
        while(left <= right){
            int midPoint = left+(right-left)/2;

            if(guess(midPoint)== 0){
                return midPoint;
            }else if(guess(midPoint) ==1){
                left = midPoint+1;
            }else{
                right = midPoint-1;
            }
        }
        return -1;
        
    }
}