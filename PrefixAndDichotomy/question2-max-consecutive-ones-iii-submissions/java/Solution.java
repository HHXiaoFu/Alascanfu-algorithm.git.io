/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/30 21:42
 * @description： Leetcode 1004 最大连续1的个数Ⅲ
 * @modified By： Alascanfu
 **/
class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i = 1; i<=n;i++){
            sum[i] = nums[i-1] + sum[i-1];
        }
        int res = 0;
        for (int i = 1;i<=n;i++){
            int l = 1;
            int r = i;
            while (l < r){
                int mid = l + r >> 1;
                if (check(sum,mid,i,k)){
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }
            if (check(sum,r,i,k))res = Math.max(res,i-r+1);
        }
        return res;
    }
    boolean check(int[] sum ,int l , int r ,int k){
        int tol = sum[r] - sum[l-1];
        int len = r - (l - 1);
        return len - tol <= k;
    }
}
