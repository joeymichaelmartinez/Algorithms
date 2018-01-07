package pentagonSolver;
import java.util.Collections;
 

import java.awt.List;
import java.util.ArrayList;

public class PentagonSolver {
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(0);        
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        int i=0;
        while(i < 3628800-1){
            pentagonChecker(solver(nums));
            i++;
        }
    }
    
    public static ArrayList<Integer> solver(ArrayList<Integer> nums){
        int temp=0;     
           int index=nums.size()-1;
            
            if(nums.get(nums.size()-1)> nums.get(nums.size()-2)){
                temp=nums.get(nums.size()-1);
                nums.set(nums.size()-1, nums.get(nums.size()-2));
                nums.set(nums.size()-2, temp);
                return nums;
            }
            
            while(nums.get(index)<nums.get(index-1)){
                index--;
            }
            temp=nums.get(index-1);
            int indexOfTemp= index-1;
            int indexOfSwap=nums.size()-1;
            while(temp>nums.get(indexOfSwap)){
                indexOfSwap--;
            }
            nums.set(nums.indexOf(temp), nums.get(indexOfSwap));
            nums.set(indexOfSwap, temp);
            ArrayList<Integer> numsSublist = new ArrayList<Integer>(nums.subList(index, nums.size()));
            Collections.reverse(numsSublist);
            int j=0;
            for(int i=index;i<nums.size(); i++){
                nums.set(i, numsSublist.get(j));
                j++;
            }
            return nums;
            
    }
    
    public static void pentagonChecker(ArrayList<Integer> nums){
        int sum1 =nums.get(0) + nums.get(1) + nums.get(2);
        int sum2 = nums.get(2) + nums.get(3) + nums.get(4);
        int sum3 = nums.get(4) + nums.get(5) + nums.get(6);
        int sum4 = nums.get(6) + nums.get(7) + nums.get(8);
        int sum5 = nums.get(8) + nums.get(9) + nums.get(0);
        if(sum1 == sum2 && sum1 == sum3 && sum1 == sum4 && sum1 == sum5){
            System.out.println(nums);
        }
    }
    
}
