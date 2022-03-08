## 高精度正整数减法（Java）

这里摘记——断了片了 好兄弟用来做笔记

**📝Java中有两个类可以用来处理高精度的计算**

`分别是处理整数的BigInteger和处理小数的BigDecimal`

## BigInteger 只可用于整数

> 构造方法

- **BigInteger(byte[] val)** 
  将包含BigInteger的二进制补码二进制表达式的字节数组转换为BigInteger 
- **BigInteger(int numBits, Random rnd)** 
  构造一个随机生成的BigInteger，均匀分布在0到（2 numBits - 1）的范围内。  
- **BigInteger(String val)** 
  将BigInteger的十进制字符串表示形式转换为BigInteger。

**模板：**

```java
	public static List<Integer> subtract(List<Integer>A ,List<Integer>B){
        List<Integer> C = new ArrayList<>();
        
        for (int i = 0,t = 0 ; i<A.size();i++){
            t = A.get(i)-t;
            if (i < B.size()){
                t -= B.get(i);
            }
            C.add( (t+10) % 10);
            t = t < 0 ? 1:0;
        }
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    } 
```

**高精度减法计算**

**注意：这种方式如果写给面试官看你会死的很惨的，知道就好可以提一下。**

```java
import java.util.*;
import java.io.*;
import java.math.*;

class Main{
    public static void main(String[] args)throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        System.out.print(a.subtract(b));
        br.close();
    }   
}
```

**Y总模板的高精度减法实现：**

- 思路：主要是通过将字符串存储到列表中逐位相减，若当前被减数不够减则需要从上一位借1，当前位+10 再减，就可以了。
- 需要注意的细节点是如果结果有多位前置0需要去除多位前置0，如果只有一位0直接返回就好了。

```java
import java.util.*;
import java.io.*;
import java.math.*;

class Main{
    public static void main(String[] args)throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        String a = br.readLine();
        String b = br.readLine();
        
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        
        for (int i = a.length()-1;i >= 0 ;i--)A.add(a.charAt(i) - '0');
        for (int i = b.length()-1;i >= 0 ;i--)B.add(b.charAt(i) - '0');
        
        List<Integer> C ;
        
        if (isGT(A,B)){
            C = subtract(A,B);
            
            for (int i = C.size()- 1;i>=0;i--){
                System.out.print(C.get(i));
            }
        }else {
            C =subtract(B,A);
            System.out.print("-");
            for (int i = C.size()- 1;i>=0;i--){
                System.out.print(C.get(i));
            }
        }
        
    }   
    
    public static boolean isGT(List<Integer>A ,List<Integer>B){
        if (A.size() != B.size())return A.size() > B.size() ? true : false;
        else {
            for (int i = B.size()-1;i >= 0;i--){
                if (A.get(i) !=B.get(i)){
                    return A.get(i) > B.get(i);
                }
            }
            return true;
        }
    }
    
    public static List<Integer> subtract(List<Integer>A ,List<Integer>B){
        List<Integer> C = new ArrayList<>();
        
        for (int i = 0,t = 0 ; i<A.size();i++){
            t = A.get(i)-t;
            if (i < B.size()){
                t -= B.get(i);
            }
            C.add( (t+10) % 10);
            t = t < 0 ? 1:0;
        }
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    } 
}
```

**📝相关类型题目：**

> [Acwing 792. 高精度减法](https://www.acwing.com/problem/content/794/)

