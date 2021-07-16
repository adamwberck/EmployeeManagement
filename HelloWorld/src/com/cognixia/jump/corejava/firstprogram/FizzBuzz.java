package com.cognixia.jump.corejava.firstprogram;

public class FizzBuzz {
    public static void main(String[] args){
        StringBuilder output = new StringBuilder();
        final int n = 100;
        for(int i=1; i < n; i++){
            if(i % 3 == 0){
                output.append("Fizz");
            }
            if(i % 5 == 0){
                output.append("Buzz");
            }
            if(!is_prime(i)) {
                System.out.println(output.length() == 0 ? i : output.toString());
            }
            output = new StringBuilder();
        }
    }

    private static boolean is_prime(int i) {
        if(i==2 || i == 3){ //subprimes
            return true;
        }
        if(i <= 1 || i % 2 == 0 || i % 3 == 0){//not prime if sub primes divide into it
            return false;
        }
        for(int j= 5; j * j <= i; j += 6){//start at 5 and check upto the square root of i
            if(i % j == 0 || i % (j + 2) == 0){
                return false;
            }
        }
        return true;
    }
}
