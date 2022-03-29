import java.util.Arrays;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/29 13:50
 * @description： Leetcode 209长度最小的子数组
 * @modified By： Alascanfu
 **/
class Solution209 {
    public int minSubArrayLen(int need, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int [] s = new int[n + 1];
        // 前缀和
        for (int i = 1 ; i<= n;i++)s[i] = nums[i-1] + s[i-1];
        for (int i = 1 ;i<= n;i++){
            int target = need + s[i-1];
            //int bound = Arrays.binarySearch(s,target);
            // 这里的 Arrays.binarySearch(s,target) 返回正数则代表的是找到数组中 target的下标位置
            // 而返回的负数是该元素没有存在于当前数组 并且返回的值取反之后不是数组的长度，那么就是返回的原数组中第一个比他大的值下标
            //if (bound < 0)bound = -bound -1;
            int bound = searchTargetAndGetIdx(s,target);
            if (bound != -1){
                res = Math.min(res,bound - (i - 1));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    int searchTargetAndGetIdx(int[] s,int target){
        int l = 0;
        int r = s.length-1;
        while (l < r){
            int mid = l + r  >> 1;
            if (s[mid] < target ){
                l = mid + 1;
            }else if (s[mid] >= target){
                r = mid ;
            }
        }
        return  s[l] >= target ? l : -1;
    }
}