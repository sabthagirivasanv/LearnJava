package com;


public class RoundRobber {

    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        if(length == 2) return Math.max(nums[0], nums[1]);


        int last2 = nums[0];
        int last1 = Math.max(nums[0], nums[1]);
        int sumWithFirst = last1;

        int last2Without = 0;
        int last1Without = nums[1];
        int sumWithoutFirst = last1Without;

        for(int i = 2; i < nums.length; i++){
            if(i != nums.length - 1){
                sumWithFirst = Math.max(last2 + nums[i], last1);
                last2 = last1;
                last1 = sumWithFirst;
            }else{
                sumWithoutFirst = Math.max(last2Without + nums[i], last1Without);
                last2Without = last1Without;
                last1Without = sumWithoutFirst;
            }
        }

        return Math.max(sumWithFirst, sumWithoutFirst);
    }

    public static void main(String[] args) {
        System.out.println(new RoundRobber().rob(new int[]{4,1,2}));
    }
}
