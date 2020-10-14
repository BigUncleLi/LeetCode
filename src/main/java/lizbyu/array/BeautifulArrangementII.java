package lizbyu.array;

import lizbyu.utils.log.LogUtils;

/*
Given two integers n and k, you need to construct a list which contains n different positive integers 
ranging from 1 to n and obeys the following requirement: 
Suppose this list is [a1, a2, a3, ... , an], 
then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

If there are multiple answers, print any of them.

Example 1:
Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.

Example 2:
Input: n = 3, k = 2
Output: [1, 3, 2]
Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.

Note:
The n and k are in the range 1 <= k < n <= 104.
*/

public class BeautifulArrangementII {
    private static final String TAG = "BeautifulArrangementII";

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        if (k == 1) {
            for (int i = 0; i < res.length; i++) {
                res[i] = i + 1;
            }
            return res;
        }

        if (k % 2 == 0) {
            for (int i = 1; i <= (k + 2) / 2; i++) {
                res[(i - 1) * 2] = i;
            }
            for (int i = 1; i <= k / 2; i++) {
                res[i * 2 - 1] = k + 2 - i;
            }
        } else {
            for (int i = 1; i <= (k + 1) / 2; i++) {
                res[(i - 1) * 2] = k + 2 - i;
            }
            for (int i = 1; i <= (k + 1) / 2; i++) {
                res[i * 2 - 1] = i;
            }
        }

        for (int i = k + 1; i < n; i++) {
            res[i] = i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        BeautifulArrangementII arr = new BeautifulArrangementII();
        LogUtils.d(TAG, arr.constructArray(3, 1));
    }
}
