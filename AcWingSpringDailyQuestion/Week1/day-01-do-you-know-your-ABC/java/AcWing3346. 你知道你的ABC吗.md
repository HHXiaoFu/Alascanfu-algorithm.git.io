## 📝题目📝

### 📝**AcWing春季打卡活动—— 3346.你知道你的ABC吗**

> Farmer John 的奶牛正在 `mooZ` 视频会议平台上举行每日集会。
>
> 她们发明了一个简单的数字游戏，为会议增添一些乐趣。
>
> Elsie 有三个正整数 *A*、*B* 和 *C* (*A*≤*B*≤*C*）。
>
> 这些数字是保密的，她不会直接透露给她的姐妹 Bessie。
>
> 她告诉 Bessie 七个范围在 $1…10^9$ 之间的整数（不一定各不相同），并宣称这是 *A*、*B*、*C*、*A*+*B*、*B*+*C*、*C*+*A* 和 *A*+*B*+*C* 的某种排列。
>
> 给定这七个整数，请帮助 Bessie 求出 *A*、*B* 和 *C*。
>
> 可以证明，答案是唯一的。

****

> #### 输入格式
>
> 输入一行，包含七个空格分隔的整数。
>
> #### 输出格式
>
> 输出 *A*、*B* 和 *C*，用空格分隔。
>
> #### 数据范围
>
> 1≤所有输入的整数≤109
>
> #### 输入样例：
>
> ```txt
> 2 2 11 4 9 7 9
> ```
>
> #### 输出样例：
>
> ```txt
> 2 2 7
> ```

****

#### 📝思路

**题目中给出了A、B、C三个正整数，并且 $A<=B<=C$ 因为一个正整数加上另一个正整数`肯定是大于其本身的`所以很容易就能想到输入的样例当中最小的两个值肯定是可以确定分别为A和B，而C就更容易确定了因为A和B已经确定了，C就是`A+B+C`之和`减去 A和B`就能得出C `因为这三个的和一定是在输入中的最大值`，这样就简单了，主要就是一个处理排序的问题啦~** 

#### 📝代码实现

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        // System.out.println("共耗时："+ (System.currentTimeMillis() - curTime) + "ms");
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
```

**这里小付用了一下快排实现排序，当然也可以直接调用Arrays.sort 方法直接对数组进行排序，这里单纯为了加深印象。**
