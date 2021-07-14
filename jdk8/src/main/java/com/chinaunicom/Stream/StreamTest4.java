package com.chinaunicom.Stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author csw
 * @date
 */
public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");
//        List<String> list1 = stream.collect(Collectors.toList());
//        List<String> list2 = stream.collect(()->new ArrayList<String>(),(theList,item) -> theList.add(item),
//                (theList1,theList2)->theList1.addAll(theList2));
        List<String> list3 = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
    }
}
