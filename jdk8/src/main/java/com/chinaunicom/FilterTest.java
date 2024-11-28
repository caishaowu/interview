package com.chinaunicom;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author csw
 * @date 2020/11/12 16:31
 */
public class FilterTest {
    public static void main(String[] args) {

        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("total", 10);
        map1.put("prov", 51);
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("total", 12);
        map2.put("prov", 52);
        List<Map<String, Integer>> list = new ArrayList<>(Arrays.asList(map1, map2));
        list = list.stream().map(m -> m.entrySet().stream().filter(p -> !p.getKey().equals("total"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))).collect(Collectors.toList());
        System.out.println(list);
    }
}
