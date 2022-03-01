/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 16:51
 * @description： SolutionInsertSort
 * @modified By： Alascanfu
 **/
class SolutionInsertSort implements SortInterface{
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0 ; i < arr.length;i++){
            // 初始化 设置当前元素下标为最小元素下标
            int minIndex = i;
            // 开始遍历 找到最小元素的下标 利用minIndex这个滚动变量进行相应的记录
            for (int j = i + 1;j < arr.length;j++){
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 找到最小的元素与当前元素进行交换
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
}
