/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 17:35
 * @description： QuickSort
 * @modified By： Alascanfu
 **/
class SolutionQucikSort implements SortInterface {
    @Override
    public int[] sort(int[] arr) {
        quickSort(arr,0, arr.length-1);
        return arr;
    }
    
    public void quickSort(int arr[],int left ,int right ){
        if (left >= right)return ;
        int i = left;
        int j = right;
        while (i < j){
            // 先从又向左找到第一个小于基值的数值下标
            while (i < j && arr[j] >= arr[left])j--;
            // 然后再从左往右找到第一个大于基值的小标
            while (i < j && arr[i] <= arr[left])i++;
            // 对应下表数值进行交换
            swap(arr,i,j);
        }
        // 将基准值与中间值进行交换
        swap(arr,i,left);
        // 递归求解 折半区域
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }
    public void swap(int arr[],int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
