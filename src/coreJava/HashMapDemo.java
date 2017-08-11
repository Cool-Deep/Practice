package coreJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class HashMapDemo {

	   public static void main(String args[]) {
	   
	      // Create a hash map
	      HashMap<String, Double> hm = new HashMap();
	      // Put elements to the map
	      hm.put("Zara", 3434.34);
	      hm.put(null, 123.22);
	      hm.put("Ayan", 1378.00);
	      hm.put("Daisy", 99.22);
	      hm.put("Qadir", -19.08);
	      
	      // Get a set of the entries
	      Set set = hm.entrySet();
	      // Get an iterator
		   // Display elements
		   for (Object aSet : set) {
			   Map.Entry me = (Map.Entry) aSet;
			   System.out.print(me.getKey() + ": ");
			   System.out.println(me.getValue());
		   }
	      System.out.println();
	      // Deposit 1000 into Zara's account
	      double balance = (Double) hm.get("Zara");
	      hm.put("Zara", balance + 1000);
	      System.out.println("Zara's new balance: " +
	      hm.get("Zara"));
	   }
	}