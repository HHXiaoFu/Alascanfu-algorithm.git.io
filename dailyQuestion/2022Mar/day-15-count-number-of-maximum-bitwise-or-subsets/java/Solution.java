/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/15 13:07
 * @description： Leetcode 每日一题2044. 统计按位或能得到的最大值的子集数目
 * @modified By： Alascanfu
 **/
class Solution2044 {

    public int countMaxOrSubsets(int[] nums) {
        int maxOfBitOr = 0;
        for (int i : nums)maxOfBitOr |= i;
        return dfs(nums,0,0,maxOfBitOr);
    }
    
    int dfs(int[] nums,int u ,int val ,int maxOfBitOr){
        if (u == nums.length){
            return val == maxOfBitOr ? 1 : 0;
        }
        return dfs(nums,u+1,val,maxOfBitOr)+dfs(nums,u+1,val | nums[u] ,maxOfBitOr);
    }
}
