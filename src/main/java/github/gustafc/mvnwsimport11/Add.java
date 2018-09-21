package github.gustafc.mvnwsimport11;

import java.lang.invoke.MethodHandles;

import calculator.Calculator;


public class Add {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: " + MethodHandles.lookup().lookupClass().getName() + " intA intB");
        }
        int intA = Integer.parseInt(args[0]);
        int intB = Integer.parseInt(args[1]);
        Calculator calculator = new Calculator();
        System.out.printf("%d + %d = ", intA, intB);
        int added = calculator.getCalculatorSoap().add(intA, intB);
        System.out.println(added);
    }

}
