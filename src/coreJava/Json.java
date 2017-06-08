package coreJava;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.json.simple.JSONObject;

class Json {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();

		obj.put("name", 10);
		obj.put("num", new Integer(100));
		obj.put("balance", new Integer(1000));
		obj.put("is_vip", new Integer(1));
		System.out.print("Before sorting");

		System.out.print(obj.toJSONString());
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.putAll(obj);
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
			obj.put(entry.getKey(),entry.getValue());
		}
		System.out.print("after sorting");
		 System.out.print(obj);


	}
}