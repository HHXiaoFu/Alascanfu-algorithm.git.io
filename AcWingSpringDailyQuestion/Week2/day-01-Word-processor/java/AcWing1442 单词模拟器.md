## ðé¢ç®ð

### ð**AcWingæ¥å­£æå¡æ´»å¨ââ 1442 åè¯æ¨¡æå¨**

> å¥¶ç Bessie æ­£å¨å®æå¥¹çåä½è¯¾çä¸ç¯ä½æã
>
> ç±äºå¥¹åå­å¾é¾çï¼å¥¹å³å®ç¨ä¸ä¸ªåè¯å¤çå¨æ¥è¾å¥è¿ç¯ä½æã
>
> è¿ç¯ä½æå±æ N ä¸ªåè¯ï¼ç¨ç©ºæ ¼åéã
>
> æ¯ä¸ªåè¯çé¿åº¦å¨ 1 å° 15 ä¹é´ï¼ä»ç±å¤§ååå°åå­æ¯ç»æã
>
> æ ¹æ®ä½ä¸çè¦æ±ï¼è¿ç¯ä½æéè¦ç¨ä¸ç§ç¹å«çæ¹å¼æçï¼
>
> æ¯ä¸è¡åå«çå­ç¬¦ä¸è¶è¿ K ä¸ªï¼ç©ºæ ¼ä¸è®¡ã
>
> å¹¸å¥½ Bessie çåè¯å¤çå¨è½å¤å¤çè¿æ ·çè¦æ±ï¼å®ä¼æç§å¦ä¸çæ¹å¼ï¼
>
> - å¦æ Bessie è¾å¥äºä¸ä¸ªåè¯ï¼è¿ä¸ªåè¯è½å¤æ¾è¿å½åè¡ï¼å°±æ¾å¨å½åè¡ã
> - å¦åï¼å°è¿ä¸ªåè¯æ¾å°ä¸ä¸è¡ï¼ç¶åç»§ç»­åä¸ä¸è¡æ·»å åè¯ã
>
> å½ç¶ï¼åä¸è¡ä¸­çåè¯ä¹é´ä»ç¶ç¨ä¸ä¸ªç©ºæ ¼åéãæ¯ä¸è¡çç»å°¾é½ä¸åºå½æç©ºæ ¼ã
>
> å¾ä¸å¹¸ï¼Bessie çåè¯å¤çå¨åå¥½åäºã
>
> è¯·å¸®å©å¥¹æ­£ç¡®å°æçå¥¹çä½æï¼

****

> #### è¾å¥æ ¼å¼
>
> è¾å¥çç¬¬ä¸è¡åå«ä¸¤ä¸ªç©ºæ ¼åéçæ´æ° N å Kã
>
> ä¸ä¸è¡åå« N ä¸ªåè¯ï¼åè¯ä¹é´ç¨åä¸ªç©ºæ ¼åéã
>
> ææåè¯çé¿åº¦é½ä¸è¶è¿ä¸è¡ä¸­çå­ç¬¦ä¸éæ° Kã
>
> #### è¾åºæ ¼å¼
>
> è¾åºæ­£ç¡®æçç Bessie çä½æã
>
> #### æ°æ®èå´
>
> 1â¤Nâ¤100
> 1â¤Kâ¤80
>
> #### è¾å¥æ ·ä¾ï¼
>
> ```
> 10 7
> hello my name is Bessie and this is my essay
> ```
>
> #### è¾åºæ ·ä¾ï¼
>
> ```
> hello my
> name is
> Bessie
> and this
> is my
> essay
> ```
>
> #### æ ·ä¾è§£é
>
> ç¬¬ä¸è¡åå« 7 ä¸ªéç©ºæ ¼å­ç¬¦ï¼åæ¬ âhelloâ ä»¥å âmyâã
>
> åå å¥ ânameâ ä¼ä½¿å¾ç¬¬ä¸è¡åå« 11>7 ä¸ªéç©ºæ ¼å­ç¬¦ï¼æä»¥è¿ä¸ªåè¯ä¼è¢«æ¾å°ä¸ä¸è¡ã

****

#### ðæè·¯ä¸

**åæéæ±è§£**

-  æè·¯å¨äºå½åæéiæåå½ååè¯ä½ç½®ï¼å¹¶ä¸è®°å½ `æéjæè¿è½å°è¾¾çåè¯ä½ç½®`ï¼å¦ææé´åè¯ç`å­ç¬¦æ»æ°å°äºK åè¯´ææéjå¯ä»¥åç§»`ï¼ç¶åè¾åº`iå°j`åºé´åç**ææåè¯å³å¯**ã


****

#### ðä»£ç å®ç°

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @authorï¼ Alascanfu
 * @date ï¼ Created in 2022/3/22 11:59
 * @descriptionï¼ AcWingæ¥å­£æå¡æ´»å¨ââ 1442åè¯å¤çå¨
 * @modified Byï¼ Alascanfu
 **/
class Main {
    static int N = 110;
    static String[] words;
    static void init(){
        words = new String[N];
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        String[] parmas1 = br.readLine().split(" ");
        int n = Integer.parseInt(parmas1[0]);
        int k = Integer.parseInt(parmas1[1]);
        String[] parmas2 = br.readLine().split(" ");
    
        for (int i = 1; i<= n;i++){
            words[i] = parmas2[i-1];
        }
        
        for (int i = 1 ; i<=n;){
            int j = i+1;
            int len = words[i].length();
            while ( words[j]!= null && (len+=words[j].length()) <= k )j++;
            for (int idx = i;i<j;i++){
                if (i != j-1)
                    System.out.print(words[i]+" ");
                else
                    System.out.print(words[i]);
            }
            System.out.println();
            i=j;
        }
    }
}

```

#### ðæè·¯äº

**æ´åæ¨¡æââç¬å¡è§å¾å¾èµOTZ**

-  åè¯çä½ç½®ååºæ¹ååè®°å½å½åè¿è½å¨æ¬è¡è¾åºçå­ç¬¦æ°éï¼å¦ææ æ³ç»§ç»­è¾åºï¼åæ´æ°é¿åº¦ï¼ç´æ¥æ¢è¡ã

****

#### ðä»£ç å®ç°

```java
import java.util.Scanner;

public class Main{

    static int n, k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        String s = sc.nextLine();
        String[] txt = sc.nextLine().split(" ");
        int cnt = k;

        for(int i = 0; i < n; ) {
            if(txt[i].length() <= cnt) {
                if(cnt != k) System.out.print(" ");
                cnt -= txt[i].length();
                System.out.print(txt[i++]);
            } else {
                cnt = k;
                System.out.println();
            }
        }

        System.out.println();
    }
}
```

