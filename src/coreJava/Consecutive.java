package coreJava;

class Consecutive {

	private int removeDuplicates(char input[], int t){
		
		int output = 0;
		char prev_char= 0;
		int current_char_seen=0;
		
		for(char current_char: input){
			if (current_char == prev_char){current_char_seen +=1;}
			else{
				current_char_seen = 0;
			    prev_char = current_char;
			}
			if (current_char_seen < t)
	            output += current_char;
		}
		
		return output;
		
	}
	
	 public static void main(String args[]){
	        String str = "AAABBCCDDDEFGH";
	        char input[] = str.toCharArray();
	        
	        Consecutive rcd = new Consecutive();
	        int len = rcd.removeDuplicates(input,2);
	        for(int i=0; i < len; i++){
	            System.out.print(input[i] + " ");
	        }
	    }
}
