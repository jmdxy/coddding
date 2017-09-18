package com.mycode.guava;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Joiner;

public class JoinerTest {

	public static void main(String[] args) {
		//Join string
		String[] array = new String[] { "a", "b", "c", "d" };
		String joinedStr = Joiner.on(",").skipNulls().join(array);
		System.out.println(joinedStr);
		System.out.println(uglyJoin(array));
		
		//Join map
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		String joinedMapStr = Joiner.on(",").useForNull("this is null!!").withKeyValueSeparator("|").join(map);
		System.out.println(joinedMapStr);
	}

	@Deprecated
	public static String uglyJoin(String[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				sb.append(array[i]).append(",");
			}
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

}
