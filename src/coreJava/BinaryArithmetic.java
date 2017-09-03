package coreJava;

/**
 * @author malay
 *
 */
public class BinaryArithmetic {

	 /*-------------------------- add ------------------------------------------------------------*/
    static String add(double a, double b) {
        System.out.println(a + "first val :" + b);
        int a1 = (int) a;
        int b1 = (int) b;
        String s1 = Integer.toString(a1);
        String s2 = Integer.toString(b1);
        int number0 = Integer.parseInt(s1, 2);
        int number1 = Integer.parseInt(s2, 2);

        int sum = number0 + number1;
        String s3 = Integer.toBinaryString(sum);

        return s3;
    }
    /*-------------------------------multiply-------------------------------------------------------*/

    static String multiply(double a, double b) {
        System.out.println(a + "first val :" + b);
        int a1 = (int) a;
        int b1 = (int) b;
        String s1 = Integer.toString(a1);
        String s2 = Integer.toString(b1);
        int number0 = Integer.parseInt(s1, 2);
        int number1 = Integer.parseInt(s2, 2);

        int sum = number0 * number1;
        String s3 = Integer.toBinaryString(sum);

        return s3;
    }
    /*----------------------------------------substraction----------------------------------------------*/

    static String sub(double a, double b) {
        System.out.println(a + "first val :" + b);
        int a1 = (int) a;
        int b1 = (int) b;
        String s1 = Integer.toString(a1);
        String s2 = Integer.toString(b1);
        int number0 = Integer.parseInt(s1, 2);
        int number1 = Integer.parseInt(s2, 2);

        int sum = number0 - number1;
        String s3 = Integer.toBinaryString(sum);

        return s3;
    }

    /*--------------------------------------division------------------------------------------------*/
    static String div(double a, double b) {
        System.out.println(a + "first val :" + b);
        int a1 = (int) a;
        int b1 = (int) b;
        String s1 = Integer.toString(a1);
        String s2 = Integer.toString(b1);
        int number0 = Integer.parseInt(s1, 2);
        int number1 = Integer.parseInt(s2, 2);

        int sum = number0 / number1;
        String s3 = Integer.toBinaryString(sum);

        return s3;
    }
    
    public static void main(String[] args) {
		System.out.println(add(11, 11));
	}
}
