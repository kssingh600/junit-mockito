package com.kdacademy.junit.unittestingdemo1;

public class Calculator {
    //sum
    public int doSum(int a, int b, int c){
        return a+b+c ;
    }

    //product
    public int doProd(int a, int b){
        return a*b ;
    }

    //compare
    public Boolean compareTwoNums(int a, int b){
		return a == b ;
	}
}
