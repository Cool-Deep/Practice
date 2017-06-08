package coreJava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSort {
	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		try {
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(
					"test.json"));
			String name = (String) jsonObject.get("name");
			long age = (Long) jsonObject.get("age");
			JSONArray msg = (JSONArray) jsonObject.get("memes");
			Iterator<String> iterator = msg.iterator();
			ArrayList<String> list = new ArrayList<String>();
			while (iterator.hasNext()) {
				list.add(iterator.next());
				Collections.sort(list);
			}
			System.out.println("sorting");
			for (Object str : list) {
				System.out.println(str);
			}

			JSONObject obj1 = new JSONObject();
			obj1.put("name", name);
			obj1.put("age", age);

			JSONArray jList = new JSONArray();

			for (String str : list) {
				jList.add(str);
			}
			obj1.put("memes", jList);

			FileWriter file = new FileWriter("test.json");
			file.write(obj1.toJSONString());
			file.flush();
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}