/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/2 23:32
 * @description： QuickSortTemplate1
 * K 神模板
 * @modified By： Alascanfu
 **/
public class QuickSortTemplate1 {
    public void quickSort(int[] nums,int left ,int right ){
        if (left > right)return;
        int i = left;
        int j = right;
        int x = nums[left];
        while (i < j){
            while (i < j && nums[j] > x)j--;
            while (i < j && nums[i] < x)i++;
            swap(nums,i,j);
        }
        swap(nums,i,left);
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
