import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/7 17:05
 * @description： 高精度正整数减法运算
 * @modified By： Alascanfu
 **/
public class UseOfBigIntegerSubtract {
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        String a = br.readLine();
        String b = br.readLine();
        
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        
        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) B.add(b.charAt(i) - '0');
        
        List<Integer> C;
        
        if (isGT(A, B)) {
            C = subtract(A, B);
            
            for (int i = C.size() - 1; i >= 0; i--) {
                System.out.print(C.get(i));
            }
        } else {
            C = subtract(B, A);
            System.out.print("-");
            for (int i = C.size() - 1; i >= 0; i--) {
                System.out.print(C.get(i));
            }
        }
        
    }
    
    /**
     * 功能描述
     * 判断当前 A 是否大于 B
     * @date 2022/3/8
     * @author Alascanfu
     */
    public static boolean isGT(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) return A.size() > B.size() ? true : false;
        else {
            for (int i = B.size() - 1; i >= 0; i--) {
                if (A.get(i) != B.get(i)) {
                    return A.get(i) > B.get(i);
                }
            }
            return true;
        }
    }
    
    /**
     * 功能描述
     * 高精度逐位相减 是否需要高位借1方式等
     * @date 2022/3/8
     * @author Alascanfu
     */
    public static List<Integer> subtract(List<Integer> A, List<Integer> B) {
        List<Integer> C = new ArrayList<>();
        
        for (int i = 0, t = 0; i < A.size(); i++) {
            t = A.get(i) - t;
            if (i < B.size()) {
                t -= B.get(i);
            }
            C.add((t + 10) % 10);
            t = t < 0 ? 1 : 0;
        }
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    }
}
