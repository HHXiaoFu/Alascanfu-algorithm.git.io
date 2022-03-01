/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 18:07
 * @description： ShellSort
 * @modified By： Alascanfu
 **/
class SolutionShellSort implements SortInterface{
    @Override
    public int[] sort(int[] arr) {
        // 设置一个增量为当前数组长度的一半
        int gap = arr.length / 2;
        // 直至增量分组缩小增量到1之前都要进行排序
        while (gap > 0 ){
            // 对于两两分组元素进行插入排序
            for (int i = gap ; i< arr.length;i++){
                int gapNum = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > gapNum){
                    arr[gap + preIndex] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[gap + preIndex] = gapNum;
            }
            gap /= 2;
        }
        return arr;
    }
}
