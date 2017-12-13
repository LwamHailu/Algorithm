package com.edu;

public class Fibonacci {

	private static int[] F;
	private static int countRecursiveCall = 0;

	public static void main(String[] args) {

		countRecursiveCall = 0;

		System.out.println("Fibonacci Number : " + fibonacci(30));
		System.out.println("No of recursive calls: " + countRecursiveCall);
		countRecursiveCall = 0;

		System.out.println("Fibonacci Number,Memoized Version :" + memoizedFib(30));
		System.out.println("No of recursive calls: " + countRecursiveCall);

	}

	public static int fibonacci(int n) {
		countRecursiveCall++;
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacci(n - 2) + fibonacci(n - 1);

	}

	public static int memoizedFib(int n) {

		F = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			F[i] = -1;

		}
		return bruteFibo(n);
	}

	public static int bruteFibo(int n) {
		countRecursiveCall++;
		if (F[n] < 0) {
			if (n == 0)
				F[n] = 0;
			else if (n == 1)
				F[n] = 1;
			else
				F[n] = bruteFibo(n - 2) + bruteFibo(n - 1);
		}
		return F[n];
	}
}
