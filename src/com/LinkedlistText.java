package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LinkedlistText {
	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList();
		list.add(2);
		list.add(3);
		list.addFirst(5);
		list.addLast(6);
		int b=list.removeLast();
		for (Integer a:list) {
			System.out.println(a);
		}
		Iterator it =list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		Map<String,String> map=new HashMap();
		map.put("1", "A");
		map.put("2", "B");
		map.put("3", "C");
		
		for (Object key: map.keySet()) {
			System.out.println(key+"======="+map.get(key));
		}
		
		for (Map.Entry<String,String> entry: map.entrySet()) {
			System.out.println(entry.getKey()+"******"+entry.getValue());
		}
		Stack<Integer> stack=new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		int sa=stack.pop();
		

	}
}
