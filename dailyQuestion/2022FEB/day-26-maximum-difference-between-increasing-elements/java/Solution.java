import java.util.Arrays;
import java.util.Stack;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/2/28 19:17
 * @description： 2022/02/28 Leetcode每日一题（EASY）—— 2016.增量元素之间的最大差值
 * @modified By： Alascanfu
 **/
class Solution2016 {
    public int maximumDifference1(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int i = 0 ; i< n ; i++){
            for (int j = i+1;j<n;j++){
                // 进行判定 需要进行修改最大差值的前提如题所给
                if (max < nums[j] - nums[i] && nums[i] < nums[j])
                    max = Math.max(nums[j] - nums[i],max);
            }
        }
        return max;
    }
    
    public int maximumDifference2(int[] nums) {
        int n = nums.length;
        // 初始化没有找到的情况下的结果
        int max = -1;
        // 进行遍历 ，并且设置初始位置的最小nums[i] 为第一个元素
        for (int i = 0 ,min = nums[0]; i< n ;i++){
            // 如果满足 当前元素的值 大于了 当前所处位置的最小nums[i] 则进行更新我们的最大差值
            if (nums[i] > min) max = Math.max(nums[i] - min,max);
            // 更新我们 当前位置的最小nums[i]
            min = Math.min(min,nums[i]);
        }
        return max;
    }
    
    public int maximumDifference3(int[] nums) {
        // 初始化辅助栈
        Stack<Integer> helpStack = new Stack<>();
        helpStack.push(nums[0]);
        // 初始化数据栈
        Stack<Integer> stack = new Stack<>();
        int max = -1;
        
        // 初始化
        for (int num : nums){
            stack.push(num);
            helpStack.push(Math.min(num,helpStack.peek()));
        }
        
        while (!stack.isEmpty() ){
            // 获取判断差值
            max = Math.max(stack.pop() - helpStack.pop(),max);
        }
        // 这步是为了防止i < j 时将其赋值引起的最小差值
        if (max == 0)return -1;
        return max;
    }
}