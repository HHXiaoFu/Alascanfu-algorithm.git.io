import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/6 16:38
 * @description： 数的三次方根
 * @modified By： Alascanfu
 **/
public class CubicOfNum {
    public static void main(String[] args )throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        double n = Double.parseDouble(br.readLine());
        
        double l = 0 ,r = Math.abs(n) + 1;
        
        while (r - l > 1e-8){
            double mid = (l + r)  / 2 ;
            if (mid * mid * mid >= Math.abs(n)) r = mid;
            else l = mid;
        }
        
        if (n >= 0 ){
            System.out.print(String.format("%.6f",l));
        }else System.out.print("-"+String.format("%.6f",l));
    }
}
