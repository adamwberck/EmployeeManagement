import java.math.BigInteger;

public class RegexDemo {
    public static void main(String[] args){
        BigInteger large_hex = new BigInteger("a9046c73e00331af68917d3804f70655",16);
        System.out.println(large_hex.remainder(new BigInteger("100")));
    }
}
