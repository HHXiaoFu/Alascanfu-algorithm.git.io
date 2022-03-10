import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/10 18:58
 * @description： 手套
 * @modified By： Alascanfu
 **/
public class SolutionSearchGloves {
    public static void main(String[] args) throws IOException {
        // `4,[0,7,1,6]，[1,5,0,6]`
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        int n = Integer.parseInt(br.readLine());
        String[] params1 = br.readLine().split(",");
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(params1[i]);
        }
        String[] params2 = br.readLine().split(",");
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            right[i] = Integer.parseInt(params2[i]);
        }
    
        System.out.println("最少需要拿出："+searchGloves(left, right)+"个手套才能有配对的手套");
    }
    
    //
    // `4,[0,7,1,6]，[1,5,0,6]`
    //
    //  4,[2,6,1,4], [2,1,4,4]
    public static int searchGloves(int[] left, int[] right) {
        // 需要找出最少需要拿出多少左右手套之和才能出现一对配套的手套
        int minSearchCnt = 0;
        // 左手套总数
        int leftSum = 0;
        // 右手套总数
        int rightSum = 0;
        // 左手套中除去0手套数最少的手套数量的手套值
        int leftMin = Integer.MAX_VALUE;
        // 右手套中除去0手套数最少的手套数量的手套值
        int rightMin = Integer.MAX_VALUE;
        // 有0手套数的个数
        int zero = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] * right[i] == 0) {
                zero += left[i] + right[i];
            } else {
                leftSum += left[i];
                rightSum += right[i];
                leftMin = Math.min(leftMin, left[i]);
                rightMin = Math.min(rightMin, right[i]);
            }
        }
        // Math.min(leftSum-leftMin+1,rightSum-rightMin+1) 我们可以知道当前左手套在不计没有手套的个数情况下
        // ，最坏的能拿到所有颜色数量各一个的情况
        // 如果出现了 手套数为0的情况则需要再拿上与每个 0个手套对应的另一只手套个数
        minSearchCnt = Math.min(leftSum-leftMin+1,rightSum-rightMin+1) + zero + 1;
        return minSearchCnt;
    }
}
