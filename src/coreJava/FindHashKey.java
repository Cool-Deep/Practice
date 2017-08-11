package coreJava;

class FindHashKey<K> {
    private int hash(K key){

        int capacity = 4;
        return Math.abs(key.hashCode()) % capacity;
	   }
	void put(K newKey){
		int hash=hash(newKey);
		System.out.println(hash);
	}
	public static void main(String[] args) {
		FindHashKey<Integer> hashMapCustom = new FindHashKey<>();
		hashMapCustom.put(29);
		hashMapCustom.put(30);
		hashMapCustom.put(30);
		hashMapCustom.put(31);
		hashMapCustom.put(32);
		hashMapCustom.put(33);
		
	}
}
