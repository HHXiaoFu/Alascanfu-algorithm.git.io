/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 17:10
 * @description： MergeSort
 * @modified By： Alascanfu
 **/
class SolutionMergeSort implements SortInterface{
    @Override
    public int[] sort(int[] arr) {
        mergeSort(arr,0, arr.length-1);
        return arr;
    }
    
    public void mergeSort(int[] arr,int left ,int right ){
        // 递归终止条件
        if (left == right)return ;
        // 折半分组
        int mid = left + (right - left)/2;
        // 对左侧的分组再次进行折半分组递归划分
        mergeSort(arr,left,mid);
        // 对右侧的分组再次进行折半分组递归划分
        mergeSort(arr,mid+1,right);
        // 对划分后的分组进行排序合并
        merge(arr,left,mid,right);
    }
    
    public void merge(int[] arr ,int left,int mid ,int right ){
        // 记录结果
        int tmp[] = new int [right - left + 1];
        // 记录结果指针
        int resultIdx = 0 ;
        // 折半数组左数组指针起始位置
        int cur1 = left;
        // 折半数组右数组指针起始位置
        int cur2 = mid + 1;
        // 进行排序合并数组
        while (cur1 <= mid && cur2 <= right){
            tmp[resultIdx++] = arr[cur1] < arr[cur2] ? arr[cur1++] : arr[cur2++];
        }
        // 如果还有划分的区域剩下了数据 则单独再将剩下的数据填充到临时结果数组中
        while (cur1 <= mid){
            tmp[resultIdx++] = arr[cur1++];
        }
        
        while (cur2 <= right){
            tmp[resultIdx++] = arr[cur2++];
        }
        // 填入结果
        for (int i = 0 ;i< tmp.length;i++){
            arr[left + i] = tmp[i];
        }
        
    }
}
