package mlq.qunaer;

import java.util.Random;

/**
 * Created by lenovo on 2017/11/4.
 */

public class RandomNumber {
    private static final String[] chars={"1","2","3","4","5","6","7","8","9","0"};
    private static Random random=new Random();
    private static final int CodeLength=4;
   static String createRandomText(){
   StringBuilder buffer=new StringBuilder();
       for(int i=0;i<CodeLength;i++){
           buffer.append(chars[random.nextInt(chars.length)]);
       }
       return buffer.toString();
   }

}
