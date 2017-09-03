/**
 * 
 */
package coreJava;

/**
 * @author malay
 *
 */
public class BinaryStringAddition {

	public static String binaryAddition(String s1, String s2) {
	    if (s1 == null || s2 == null) return "";
	    int first = s1.length() - 1;
	    int second = s2.length() - 1;
	    StringBuilder sb = new StringBuilder();
	    int carry = 0;
	    while (first >= 0 || second >= 0) {
	        int sum = carry;
	        if (first >= 0) {
	            sum += s1.charAt(first) - '0';
	            first--;
	        }
	        if (second >= 0) {
	            sum += s2.charAt(second) - '0';
	            second--;
	        }
	        carry = sum >> 1;
	        sum = sum & 1;
	        sb.append(sum == 0 ? '0' : '1');
	    }
	    if (carry > 0)
	        sb.append('1');

	    sb.reverse();
	    return String.valueOf(sb);
	}
	
	 static String add(String a, String b) {
	        System.out.println(a + "first val :" + b);
	       /* int a1 = (int) a;
	        int b1 = (int) b;
	        String s1 = Integer.toString(a1);
	        String s2 = Integer.toString(b1);*/
	        int number0 = Integer.parseInt(a, 2);
	        int number1 = Integer.parseInt(b, 2);

	        int sum = number0 + number1;
	        String s3 = Integer.toBinaryString(sum);

	        return s3;
	    }
	
	public static void main(String[] args) {
		String s1 = "10110";
		String s2 = "1011";
		System.out.println(binaryAddition(s1, s2));
		//System.out.println(add(s1, s2));
	}
}
