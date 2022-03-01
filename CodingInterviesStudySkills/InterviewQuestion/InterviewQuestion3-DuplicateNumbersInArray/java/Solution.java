/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 21:12
 * @description： 《剑指offer》面试题3：数组中重复的数字
 * @modified By： Alascanfu
 **/
class SolutionDuplicateNumberInArray {
    public int findRepeatNumber(int[] nums) {
        // 测试考虑用例
        if (nums == null || nums.length < 0)return -1;
        for (int i:nums){
            if (i < 0 || i >nums.length)return -1;
        }
        
        int idx = 0;
        while (idx < nums.length){
            if (nums[idx] == idx){
                idx++ ;
                continue;
            }
            int tmp = nums[nums[idx]];
            if (nums[idx] == tmp)return nums[idx];
            
            nums[nums[idx]] = nums[idx];
            nums[idx] = tmp;
        }
        return -1;
    }
}
