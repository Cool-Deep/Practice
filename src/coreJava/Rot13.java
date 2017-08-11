package coreJava;

class Rot13 {


	public static void main(String[] args) {
        String s = args[0];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if       (c >= 'a' && c <= 'w') c += 3;
            else if  (c >= 'A' && c <= 'W') c += 3;
            else if  (c >= 'x' && c <= 'z') c -= 23;
            else if  (c >= 'X' && c <= 'Z') c -= 23;
           System.out.println(c);
        }
        System.out.println();
    }
}
