/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 15:27
 * @description： BubbleSort实现
 * @modified By： Alascanfu
 **/
class SolutionBubbleSort implements SortInterface{
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0 ;i < arr.length;i++){
            for (int j = 0 ; j< arr.length - i -1;j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
}
