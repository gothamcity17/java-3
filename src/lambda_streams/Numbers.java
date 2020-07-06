package lambda_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wheever possible.
        System.out.println(nums);

        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls, or defined them first, then pass them into the methods. give them the same names as the static methods, but add the word 'lambda' in front of every lambda function:
        /* e.g.

        added(() -> {});

        OR

        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});

        OR

        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...

        */

        Lam2 LambdaIsOdd = (int x) -> isOdd(x);
        Lam2 LambdaIsEven = (int x) -> isEven(x);
        Lam2 LambdaIsPrime = (int x) -> isPrime(x);
        Lam3 LambdaAdded = () -> added();
        Lam3 LambdaSubtracted = () -> subtracted();
        Lam3 LambdaMultiplied = () -> multipled();
        Lam3 LambdaDivided = () -> divided();
        Lam3 LambdaFindMax = () -> findMax();
        Lam3 LambdaFindMin = () -> findMin();
        Lam LambdaCompare = (int x, int y) -> compare(x, y);
        Lam4 LambdaAppend = (int x) -> append(x);

    }

    interface Lam {
        int op(int a, int b);
    }

    interface Lam2 {
        boolean op(int a);
    }

    interface Lam3 {
        int op();
    }

    interface Lam4 {
        int op(int a);
    }

    private int operate(int a, int b, Lam Obj) {
        return Obj.op(a, b);
    }

    private boolean operate2(int a, Lam2 Obj) {
        return Obj.op(a);
    }

    private int operate3(Lam3 Obj) {
        return Obj.op();
    }

    private int operate4(int a, Lam4 Obj) {
        return Obj.op(a);
    }

    static boolean isOdd(int i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        if (nums.get(i) % 2 != 0) {
            return true;
        } else{
            return false;
        }
    }

    static boolean isEven(int i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        if (nums.get(i) % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPrime(int i) {
        //determine if the value at the index i is a prime number.  return true if yes, return false if no.
        for (int x = 0;  x * 2 < i; x++) {
            if (i % x == 0) {
                return false;
            }
        }
        return true;
    }

    static int added() {
        //add all the elements in the list.  return the sum.
        int sum = nums.stream()
                .mapToInt(Integer::intValue).sum();
        return sum;
    }

    static int subtracted() {
        //subtract all the elements in the list. return the remainder.
        int remainder = nums.stream()
                .reduce(0, (n1, n2)-> n1 - n2);
        return 0;
    }

    static int multipled() {
        //multiply all the elements in the list. and return the product.
        int product = nums.stream()
                .reduce(0, (x, y)-> x * y);
        return product;
    }

    static int divided() {
        //multiply all the elements in the list. and return the product.
        int quotient = nums.stream()
                .reduce(0, (x, y)-> x/y);
        return 0;
    }

    static int findMax() {
        int  maxNum = nums.stream()
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();
         //return the maximum value in the list.
        return maxNum;
    }

    static int findMin() {
        //return the minimum value in the list.
        int minNum = nums.stream()
                .collect(Collectors.summarizingInt(Integer::intValue)).getMin();
        return 0;
    }

    static int compare(int i, int j) {
        //compare the values stored in the array at index position i and j.  
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        if (i > j) {
            return 1;
        } else {
            return -1;
        }
    }

    static int append(int n) {
        //add a new value to the values list. return that value after adding it to the list.
        nums.add(n);
        return n;
    }
}
