import java.util.ArrayDeque;
import java.util.Deque;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/4 11:08
 * @description： Leetcode 每日一题. 2104. 子数组范围和 2022/03/04
 * @modified By： Alascanfu
 **/
class Solution2104{
    /** 方法1 */
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        // 用于记录结果的滚动变量
        long res = 0L;
        for (int i = 0 ; i< n;i++){
            // 记录当前子数组范围内的最大值和最小值
            int max = nums[i];
            int min = nums[i];
            // 枚举子范围区间的数值进行计算
            for (int j = i + 1;j<n;j++){
                // 通过max和min这两个滚动变量分别记录当前子数组范围内最大值和最小值
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                // 返回子范围数组的最大差值返回
                res += max - min;
            }
        }
        return res;
    }
    
    
    int n ;
    /** 方法2 单调栈 找最近下标*/
    public long subArrayRanges1(int[] nums) {
        n = nums.length;
        long[] min = getCnt(nums,true),max = getCnt(nums,false);
        long res = 0 ;
        for (int i = 0 ; i < n ;i++)res += (max[i] - min[i])*nums[i];
        return res;
    }
    
    public long[] getCnt(int [] nums,boolean isMin){
        int[] a = new int[n],b = new int[n];
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0 ; i< n;i++){
            while (!dq.isEmpty() && (isMin ? nums[dq.peekLast()] >= nums[i] : nums[dq.peekLast()] <=nums[i]))dq.pollLast();
            a[i] = dq.isEmpty() ? -1 : dq.peekLast();
            dq.addLast(i);
        }
        
        dq.clear();
        for (int i = n-1;i>=0;i--){
            while(!dq.isEmpty() && (isMin ? nums[dq.peekLast()] > nums[i] : nums[dq.peekLast()] < nums[i]))dq.pollLast();
            b[i] = dq.isEmpty() ? n : dq.peekLast();
            dq.addLast(i);
        }
        
        long[] res = new long[n];
        for (int i = 0 ; i< n ;i++)res[i] = (i - a[i]) * 1L * (b[i] - i);
        return res;
    }
}
