package com.fourthis4.leetcode;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int right = 0;

        for (int i=0;i<weights.length;i++){
            right += weights[i];
        }

        int left = 1;
        int mid = 0;
        int result = 0;
        while(left <= right){
            mid = (left + right) / 2;
            int count = 0;
            int tmp = 0;
            for(int i=0;i<weights.length;i++){
                tmp += weights[i];
                if (tmp > mid){
                    count++;
                    if (weights[i] > mid){
                        count = D + 1;
                        break;
                    } else {
                        tmp = weights[i];
                    }

                }
            }
            count++;

            if(count <= D){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays obj = new CapacityToShipPackagesWithinDDays();

        System.out.println(obj.shipWithinDays(new int[]{ 1,1,1,1,1,1,500}, 2));
    }
}
