package com.JavaEx55.jse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaEx55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		
		map.put("½Å´çµ¿", "¶±ººÀÌ");
		map.put("»ç´çµ¿", "±ò¸®");
		map.put("°¡»ê", "ÂÞ²Ù¹Ì");
		map.put("¼ö¿ø", "°¥ºñ");
		map.put("È«´ë", "¿±¶±");
		
		System.out.println("Map size : " + map.size());
		System.out.println("random key/value : " + map.get("°¡»ê"));
		
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		
		while(it.hasNext())
		{
			Entry<String, String> keyEntry = it.next();
			String key = keyEntry.getKey();
			String value = keyEntry.getValue();
			System.out.println(key + " = " + value);
		}
	}

}
