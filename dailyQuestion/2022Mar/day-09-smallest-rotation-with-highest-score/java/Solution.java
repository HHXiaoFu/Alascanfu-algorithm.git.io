/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/9 16:37
 * @description： Leetcode每日一题 798. 得分最高的最小轮调 2022/03/09
 * @modified By： Alascanfu
 **/
class Solution798 {
    public int bestRotation(int[] nums) {
        int val = 0,n = nums.length;
        // 定义的是一个经过k次轮换后 此时nums中的值与下标相等的个数
        int[] moveCurVal2ValIdxStep = new int[n];
        // 这里是用来找到 当前数组的当前值需要转换多少次才能到达对应其值的下标 至于为什么可以这样呢？ 这里不会越界么？
        // 题中给的提示告诉我们了 数组中的每个值都是小于数组长度的 0 <= nums[i] < nums.length 这样就不可能会越界
        for (int i = 0 ; i< n;i++){
            // 如果当前的值是大于下标的所以他肯定需要轮换到第一个之后再进行轮换才可能到达当前的值对应的下标
            // moveCurVal2ValIdxStep[i+n-nums[i]]++ 我们可以理解为当前数值需要轮换 ？ 次才能使得当前数值与下标相同
            // 使得在？次时的个数+1，即可遍历数组中每个数字需要经过？次轮换才能到达下标值与下标相同位置的个数啦~
            if (nums[i] > i)moveCurVal2ValIdxStep[i + n - nums[i]]++;
                // 这里是如果我们当前的下标都大于或者等于当前值了，
                //我们就直接计算轮换 i - nums[i] 次就可以使得我们的当前值得下标 = 当前值
            else moveCurVal2ValIdxStep[i-nums[i]]++;
        }
        int k = 0 ,maxVal = val;
        for (int i = 1;i< n;i++){
            // 状态转换方程 dp[i] = dp[i-1] + (k-1次轮换时此时下标等于下标对应值的个数
            // 即 下标0时 nums[0] = 0的情况下) + 1 (这里为什么要加1呢
            // 因为当我们第一个的值转换后就会到数组的最后一个位置此时最后位置的数值一定是大于等于 0 的所以需要+1)
            val = val - moveCurVal2ValIdxStep[i-1] + 1;
            // 通过滚动变量val 找到最大值记录当前的转换次数k 得到转换 k 次能得到最大的分数
            if (val > maxVal){
                maxVal = val;
                k = i;
            }
        }
        return k;
    }
}
