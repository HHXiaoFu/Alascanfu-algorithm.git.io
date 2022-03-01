/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 18:15
 * @description： SelectionSort
 * @modified By： Alascanfu
 **/
class SolutionSelectionSort implements SortInterface {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0 ; i< arr.length;i++){
            int minIdx = i;
            for (int j = i+1;j< arr.length;j++){
                if (arr[minIdx] >= arr[j])minIdx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
        return arr;
    }
}
