import java.util.Random;
import java.util.Scanner;

public class Enshu6_11{
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    // 要素数
    static int elementsNum = 0;
    // 要素数下限
    static final int lowerLimit = 1;
    // 要素数上限
    static final int upperLimit = 10;

    public static void main(String[] args) {
        
        // lowerLimit〜upperLimitの整数が入力されるまでループを回し続ける
        while (elementsNum < lowerLimit || elementsNum > upperLimit) {
            try {
                System.out.print("要素数は？（1〜" + upperLimit + "の整数でお答えを！）：");
                elementsNum = Integer.parseInt(scan.next());    
                if (isOutRange(elementsNum)) {
                    System.out.println("範囲外なのでは？");
                } else {
                    System.out.println("------------スタート------------");
                }    
            } catch (Exception e) {
                System.out.println("整数ではないのでは？");
            }
        }

        // 要素数elementNum個の配列を用意
        int[] notDuplicatedArray = new int[elementsNum];

        // ループ1：notDuplicatedArray[]に順番にランダムな値を代入する
        for (int i = 0; i < elementsNum; i++) {
            notDuplicatedArray[i] = makeRandomNum1toUpperLimit();
            System.out.println("最初の" + makeStringByIntegers(i,notDuplicatedArray[i]));

            // ループ2：notDuplicatedArray[i]と一致するものがnotDuplicatedArray[0]〜notDuplicatedArray[i-1]にあるか確認する
            for (int j = 0; j < i; j++) {
                System.out.println(makeStringByIntegers(i,notDuplicatedArray[i]) + " と " + makeStringByIntegers(j,notDuplicatedArray[j]) + " を比較");
                if (notDuplicatedArray[i] == notDuplicatedArray[j]) {
                    // 一致するものがある場合、ランダムな値を入れ直す
                    notDuplicatedArray[i] = makeRandomNum1toUpperLimit();
                    System.out.println("入替後の" + makeStringByIntegers(i,notDuplicatedArray[i]));
                    //もう一度ループ2を回すためインデックスjを初期化、j++のため-1
                    j = -1;
                    // これでもできるけど、ループ1を同じインデックスiで回すためランダム値代入を2度行っていて冗長
                    // i--;
                }
            }
            System.out.println("最終的な"+ makeStringByIntegers(i,notDuplicatedArray[i]));
            System.out.println("--------------------------------");
        }

        // もう一度最後に出力
        for (int i = 0; i < elementsNum; i++) {
            System.out.println(makeStringByIntegers(i,notDuplicatedArray[i]));
        }
    }

    // 1〜upperLimitの乱数を生成するためのメソッド
    public static int makeRandomNum1toUpperLimit() {
        return rand.nextInt(upperLimit) + 1;
    }

    // 範囲外かどうかを判断するためのメソッド
    public static boolean isOutRange(int inputNum) {
        Boolean result = false;
        // 範囲外だったらtrueを返す
        if (inputNum < lowerLimit || inputNum > upperLimit) {
            result = true;
        }
        return result;
    }

    // 配列の出力用文言（a[first]：second）をバッファで作成するためのメソッド
    public static String makeStringByIntegers(int first, int second) {
        StringBuilder buff = new StringBuilder();
        buff.append("a[");
        buff.append(first);
        buff.append("]：");
        buff.append(second);
        return buff.toString();
    }

}