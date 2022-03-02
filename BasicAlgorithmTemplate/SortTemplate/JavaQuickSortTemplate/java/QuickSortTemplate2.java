/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/2 22:42
 * @description： QuickSortTemplate2
 * y 总模板
 * @modified By： Alascanfu
 **/
public class QuickSortTemplate2 {
    public void quickSort(int[] nums,int left,int right ){
        if (left >= right)return ;
        int i = left - 1;
        int j = right + 1;
        
        int pivot = nums[left + right >> 1];
        while (i < j){
            do {
                i++;
            }while(nums[i] < pivot);
            do {
                j--;
            }while(nums[j] > pivot);
            if (i < j) swap(nums,i,j);
        }
        quickSort(nums, left, j);
        quickSort(nums,j+1,right);
        
    }
    public void swap(int[] nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
