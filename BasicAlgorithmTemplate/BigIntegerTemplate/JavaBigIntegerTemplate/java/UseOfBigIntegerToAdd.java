import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/7 15:16
 * @description： 如何在Java中使用高精度加法计算
 * @modified By： Alascanfu
 **/
public class UseOfBigIntegerToAdd {
    /**
     *功能描述
     * Y总的高精度加法模板
     * @date 2022/3/7
     *  @author Alascanfu
     */
    public static List<Integer> add(List<Integer> A, List<Integer> B){
        List<Integer> c = new ArrayList<>(Math.max(A.size(),B.size()+2));
        int tmp = 0;
        for (int i = 0 ;i<A.size()||i<B.size();i++){
            if(i<A.size())tmp+=A.get(i);
            if(i<B.size())tmp+=B.get(i);
            c.add(tmp%10);
            tmp/=10;
        }
        if(tmp > 0)c.add(tmp);
        return c;
    }
    public static void bigIntegerAdd() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
    
        String a = br.readLine();
        String b = br.readLine();
        // 判断是否需要进位
        int addOne = 0;
        // 获取当前字符的长度
        int aLen = a.length(),bLen = b.length();
        StringBuilder res = new StringBuilder();
        // 逐位进行计算是否需要进位
        while (aLen > 0 || bLen > 0){
            // 这里三元运算判断是为了防止当一个整数位数计算之后没有位数进行计算了所以需要的
            int aNum = aLen > 0 ? a.charAt(aLen-1) - '0' : 0,bNum = bLen > 0 ? b.charAt(bLen-1)-'0' : 0;
            // 这里是判断当前位上的数值
            int num = (aNum + bNum + addOne) % 10;
            // 这里判断是否需要进行进位
            addOne = (addOne + aNum + bNum) / 10;
            // 将当前位数进行追加入结果当中
            res.append(num);
            // 逐位计算
            aLen--;
            bLen--;
        }
        // 如果最高位有进位也需要将结果追加其中
        if (addOne > 0)res.append(addOne);
        // 反转输出结果
        System.out.print(res.reverse().toString());
        br.close();
    }
    
    public static void bigIntegerAdd1() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
    
        String a = br.readLine();
        String b = br.readLine();
    
        BigInteger numA = new BigInteger(a);
        BigInteger numB = new BigInteger(b);
        System.out.println(numA.add(numB));
        br.close();
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("正整数高精度相加计算:");
        bigIntegerAdd();
        
    }
}
