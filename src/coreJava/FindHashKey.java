package coreJava;

public class FindHashKey<K> {
	private int capacity=4;
	private int hash(K key){
	       
		return Math.abs(key.hashCode()) % capacity;
	   }
	public void put(K newKey){
		int hash=hash(newKey);
		System.out.println(hash);
	}
	public static void main(String[] args) {
		FindHashKey<Integer> hashMapCustom = new FindHashKey<Integer>();
		hashMapCustom.put(29);
		hashMapCustom.put(30);
		hashMapCustom.put(30);
		hashMapCustom.put(31);
		hashMapCustom.put(32);
		hashMapCustom.put(33);
		
	}
}
