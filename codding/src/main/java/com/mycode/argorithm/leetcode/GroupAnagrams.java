package com.mycode.argorithm.leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 *
 * @author zhangxu
 * @see https://leetcode.com/problems/anagrams/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>(0);
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        //Arrays.sort(strs);
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            // 改成map.putIfAbsent(keyStr, new ArrayList<String>());也可以
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * 性能比较差
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        return Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return String.valueOf(c);
        })).values().stream().collect(Collectors.toList());
    }

    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        assertThat(groupAnagrams(strs).size(), is(3));
        assertThat(groupAnagrams2(strs).size(), is(3));
    }
}
