package coreJava;

import java.util.ArrayList;
import java.util.Collection;


class Folders {
    private static Collection<String> folderNames(String xml, char startingLetter) {
        
    	ArrayList<String> selectedFolders = new ArrayList<>();
    	
    	String preStr = "<folder name=\"";
        int preStrLen = preStr.length();
        
        String postStr = "\">";
        int postStrLen = postStr.length();
        String postStr2 = "\" />";
        
        while(xml.length() != 0 && xml.contains(preStr)){

        	int startIndex = xml.indexOf(preStr);
        	int endIndex = xml.indexOf(postStr);
        	if (endIndex == -1){
        		endIndex = xml.indexOf(postStr2);
        	}
        	
        	String folderName = xml.substring(startIndex + preStrLen, endIndex);
        	
        	if(folderName.charAt(0) == startingLetter){
        		selectedFolders.add(folderName);
        	}
        	
        	xml = xml.substring(endIndex + postStrLen);
            
        }
        return selectedFolders;
    }
    
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                    "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";
        System.out.println(xml);
        
        
        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}