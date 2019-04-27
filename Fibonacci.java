class Fibonacci {

	public static void main(String[] args) {

		int fibonacci1 = 1;
		int fibonacci2 = 1;
		int fibonacci3 = 1;
		int fibonacciSum = 2;

		while (fibonacciSum < 150000) {
			fibonacci1 = fibonacci2;
			fibonacci2 = fibonacci3;
			fibonacci3 = fibonacci2 + fibonacci1;
			fibonacciSum += fibonacci3;
		}

		System.out.println(fibonacci2);
	
	}
}
