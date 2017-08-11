package coreJava;

class ReverseWordInString {

	 public static void main(String args[])
	    {
	        String myName = "Here we go";
	        StringBuffer s = new StringBuffer();
	        int x=myName.length();
	        for(int i=myName.length()-1;i>=0;i--){
	        	
	        	if(myName.charAt(i)==' '){
	        		s.append(myName.substring(i+1,x));
	        		s.append(" ");
	        		x=i;
	        	}
	        }
	        
	        s.append(myName.substring(0,x));
	        System.out.println(s);
	        
	    }    
/*	Method-2 
 *        ArrayList al = new ArrayList();
	        al = recursiveReverseMethod(myName,al);
	        al.trimToSize();
	        StringBuilder sb = new StringBuilder();
	        for(int i = al.size()-1; i>=0;i--)
	        {
	            sb.append(al.get(i)+" ");

	        }
	        System.out.println(sb);

	    }
	    public static ArrayList  recursiveReverseMethod(String myName,ArrayList al)
	    {

	        int index = myName.indexOf(" ");
	        al.add(myName.substring(0, index));
	        myName  = myName.substring(index+1);
	        if(myName.indexOf(" ")==-1)
	        {
	            al.add(myName.substring(0));
	            return al;
	        }
	        return recursiveReverseMethod(myName,al);

	    }
	}
	
	
	* Method-3
	
	public static String reverseWordsWithoutSplit(String sentence){
	    if (sentence == null || sentence.isEmpty()) return sentence;
	    int nextSpaceIndex = 0;
	    int wordStartIndex = 0;
	    int length = sentence.length();
	    StringBuilder reversedSentence = new StringBuilder();
	    while (nextSpaceIndex > -1){
	        nextSpaceIndex = sentence.indexOf(' ', wordStartIndex);
	        if (nextSpaceIndex > -1) reversedSentence.insert(0, sentence.substring(wordStartIndex, nextSpaceIndex)).insert(0, ' ');
	        else reversedSentence.insert(0, sentence.subSequence(wordStartIndex, length));
	        wordStartIndex = nextSpaceIndex + 1;
	    }

	    return reversedSentence.toString();
	}

	public static void main(String[] args) {
		String a = "My name is Malay";
		
		System.out.println(reverseWordsWithoutSplit(a));
	}
}


*Method-4

class testers {
    public static void main(String[] args) {
        String testStr="LongString";
        testers u= new testers();
        u.reverseStr(testStr);
    }
    public void reverseStr(String testStr){
        char[] d= testStr.toCharArray();
        int i;
                int length=d.length;
                int last_pos;
                last_pos=d.length-1;
                for (i=0;i<length/2;i++){
                    char tmp=d[i];
                    d[i]=d[last_pos-i];
                    d[last_pos-i]=tmp;

                }
                System.out.println(d);
              }
    }


* Method-5
import java.util.ArrayList;
public class ReverseString
{
    public static void main(String args[])
    {
        String myName = "Here we go";
        ArrayList al = new ArrayList();
        al = recursiveReverseMethod(myName,al);
        al.trimToSize();
        StringBuilder sb = new StringBuilder();
        for(int i = al.size()-1; i>=0;i--)
        {
            sb.append(al.get(i)+" ");

        }
        System.out.println(sb);

    }
    public static ArrayList  recursiveReverseMethod(String myName,ArrayList al)
    {

        int index = myName.indexOf(" ");
        al.add(myName.substring(0, index));
        myName  = myName.substring(index+1);
        if(myName.indexOf(" ")==-1)
        {
            al.add(myName.substring(0));
            return al;
        }
        return recursiveReverseMethod(myName,al);

    }
*/}