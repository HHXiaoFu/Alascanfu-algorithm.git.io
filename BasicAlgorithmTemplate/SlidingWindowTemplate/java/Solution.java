/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/30 22:04
 * @description： Leetcode 1004.最大连续1的个数Ⅲ
 * @modified By： Alascanfu
 **/
class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0 ;
        for (int i = 0 ,j = 0 ,tol = 0;i<n;i++){
            tol += nums[i];
            if ((i - j + 1) > k){
                tol -= nums[j++];
            }
            res = Math.max(res,i-j+1);
        }
        return res;
    }
}
