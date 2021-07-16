import java.util.*;

public class MemFIb {
    private static final Map<Integer, Integer> mem =  new HashMap<>();//holds fib map
    public static void main(String[] args){
        var r = new Random();
        fib_print(1);
        fib_print(2);
        fib_print(3);
        fib_print(4);
        fib_print(5);
        fib_print(6);
        fib_print(46);
        for(int i = 0; i < 5 ; i++){
            fib_print(r.nextInt(47));//bounded at 46 as fib series surpasses 0x7fffffff
        }
    }

    public static void fib_print(int n){//print n and fib at n
        System.out.print(n + " ");
        System.out.println(fib(n));
    }

    public static int fib(int n){
        if(mem.containsKey(n)){//don't re-calculate
            return mem.get(n);
        }

        if(n < 0){ // returns -1 if less than 0
            return -1;
        }
         if(n == 0) {// returns 0 if 0
            mem.put(n,0);
            return 0;
        }
        if(n <= 2){// 1 and 2 are 1
            mem.put(n,1);
            return 1;
        }

        int v = Math.addExact(fib(n-1), fib(n-2)); // add exact so don't go pass max bound
        mem.put(n , v);
        return v;
    }
}
