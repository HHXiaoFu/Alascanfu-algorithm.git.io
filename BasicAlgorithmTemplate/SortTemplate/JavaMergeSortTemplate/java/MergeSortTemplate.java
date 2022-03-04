/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/3 23:07
 * @description： MergeSortTemplate
 * @modified By： Alascanfu
 * y总模板
 **/
public class MergeSortTemplate {
    public void mergeSort(int[] nums,int left ,int right){
        // 递归结束条件
        if (left >= right)return ;
        int mid = left + right >> 1;
        // 划分
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        // 合并
        int resultIdx = 0 ;
        int cur1 = left;
        int cur2 = mid+1;
        int tmp[] = new int [right - left + 1];
        while (cur1 <= mid && cur2 <= right){
            tmp[resultIdx++] = nums[cur1] < nums[cur2] ? nums[cur1++] : nums[cur2++];
        }
        while(cur1 <= mid)tmp[resultIdx++] = nums[cur1++];
        while(cur2 <= right)tmp[resultIdx++] = nums[cur2++];
        // 需要注意的位置
        for (int i = left,j = 0;i<=right;i++,j++)nums[i] = tmp[j];
    }
}
