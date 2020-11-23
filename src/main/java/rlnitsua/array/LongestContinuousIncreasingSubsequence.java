package rlnitsua.array;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int currentLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                maxLen = Math.max(maxLen, ++currentLen);
            } else {
                currentLen = 1;
            }
        }

        return maxLen;
    }
}
