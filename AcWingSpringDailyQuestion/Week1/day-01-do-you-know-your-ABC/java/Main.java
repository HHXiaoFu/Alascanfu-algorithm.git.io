import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/14 16:51
 * @description： AcWing 3346. 你知道你的ABC吗 2022/03/14
 * @modified By： Alascanfu
 **/
class Main {
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        String[] params = br.readLine().split(" ");
        int n = params.length;
        int[] nums = new int[n];
        for (int i = 0 ; i< n;i++){
            nums[i] = Integer.parseInt(params[i]);
        }
        long curTime = System.currentTimeMillis();
//        quickSort(nums,0,n-1);
        Arrays.sort(nums);
        System.out.println("共耗时："+ (System.currentTimeMillis() - curTime) + "ms");
        System.out.println(nums[0] + " " + nums[1] + " " + (nums[n-1] - nums[0] - nums[1]));
    }
    
    static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1;
        int x = nums[(l + r) >> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }
}
