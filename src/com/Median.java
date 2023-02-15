package com;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftCount = nums1.length;
        int rightCount = nums2.length;
        int totalCount = leftCount + rightCount;
        int result = 0;

        int start1 = 0, start2 = 0;
        int end1 = leftCount - 1, end2 = rightCount -1;


        if(leftCount == 0){
            int mid = nums2.length / 2;
            if(totalCount % 2 == 0){
                result = (nums2[mid] + nums2[mid - 1]) / 2;
            }
        }

        if(rightCount == 0){
            int mid = nums1.length / 2;
            if(totalCount % 2 == 0){
                result = (nums1[mid] + nums1[mid - 1]) / 2;
            }
        }


        int mid1 = findMid(start1, end1);
        int mid2 = findMid(start2, end2);
        while(leftCount > 1 && rightCount > 1){
            mid1 = findMid(start1, end1);
            mid2 = findMid(start2, end2);
            if(nums1[mid1] < nums2[mid2]){
                start1 = mid1;
                end2 = mid2;
            }
            if(nums1[mid1] > nums2[mid2]){
                start2 = mid2;
                end1 = mid1;
            }

            if(nums1[mid1] == nums2[mid2]){
                if(totalCount % 2 == 0){
                    int otherNum = nums1[mid1 -1] > nums2[mid2 -1]
                            ? nums1[mid1]
                            : nums2[mid2];

                    return (nums1[mid1] + otherNum) / 2;
                }else{
                    return nums1[mid1];
                }
            }
            leftCount = end1 - start1 + 1;
            rightCount = end2 - start2 + 1;
        }

        int a = 0;
        int[] arr = nums1;
        int mid = mid1;
        if(leftCount == 1) {
            a = nums1[mid1];
            arr = nums2;
            mid = mid2;
        }
        if(rightCount == 1) {
            a = nums2[mid2];
            arr = nums1;
            mid = mid1;
        }

        int b = arr[mid - 1];
        int c = arr[mid];
        if(totalCount % 2 == 0){
            int d = a < b ? b : a;
            result = (d + c )/2;
        }else{
            if (a<c){
                result = b;
                if(a<b){
                    result = b;
                }else{
                    result = a;
                }
            }else{
                if(a<b)
                    result = c;
            }
        }


        return result;
    }

    int findMid(int start, int end){
        return (end + start + 1) / 2;
    }

    public static void main(String[] args) {
        Median m = new Median();
        int[] a = {1,5,9,13,20,21};
        int[] b = {2,6,20,32};
        System.out.println(m.findMedianSortedArrays(a,b));
    }
}
