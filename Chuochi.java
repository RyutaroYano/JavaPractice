import java.util.Scanner;

class Chuochi {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		try {
		
			int retry = 1;
			while (retry != 0) {

				int mid = 0;

				System.out.println("変数a：");
				int a = stdIn.nextInt();

				System.out.println("変数b：");
				int b = stdIn.nextInt();

				System.out.println("変数c：");
				int c = stdIn.nextInt();

				if ((a >= b && b >= c) || (c >= b && b >= a)) {
					mid = b;
				} else if ((b >= c && c >= a) || (a >= c && c >= b)) {
					mid = c;
				} else if ((c >= a && a >= b) || (b >= a && a >= c)) {
					mid = a;
				}

				System.out.println("中央値：" + mid);

				System.out.println("リプレイ？： if 0 then quit");

				retry = stdIn.nextInt();
			}
		} catch (Exception e){
			System.out.println(e);
		}

	}
}
