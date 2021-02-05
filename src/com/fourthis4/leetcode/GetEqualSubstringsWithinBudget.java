package com.fourthis4.leetcode;

public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {

        int sum = 0;

        int left = 0, right = 0;

        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            right++;
            if (sum > maxCost) {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
        }

        return right - left;
    }

    public int equalSubstringFaster(String s, String t, int maxCost) {
        int[] diff = new int[s.length()];

        int sum = 0;

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for (int i = 0; i < diff.length; i++) {
            diff[i] = Math.abs(sc[i] - tc[i]);
        }

        int left = 0, right = 0;

        while (right < diff.length) {
            sum += diff[right];
            right++;
            if (sum > maxCost) {
                sum -= diff[left];
                left++;
            }
        }

        return right - left;
    }
}
