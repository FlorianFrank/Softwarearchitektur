/**
 * Created by florianfrank on 29.03.16.
 */
public class MainClass {

    public static void main(String[] args){
        SimpleSplitString string1 = new SimpleSplitString("Test123");
        DualSplitString string2 = new DualSplitString("Test123");
        string2.forward2();
        string2.forward();
        System.out.println(string2);
    }
}
