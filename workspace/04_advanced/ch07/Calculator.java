package ch07;

public class Calculator {
    int add(int a, int b){
        return a + b;
    }
    double divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException();
        }
        return Math.round((a/(double)b) * 100) / 100.0;
    }
}
