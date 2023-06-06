package com.simeio.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	
	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("poppy");
		hashSet.add("ram");
		hashSet.add("rusty");
		hashSet.add("100");
		
		hashSet.add(null);
		
		System.out.println(hashSet);
		
		System.out.println("using iterator");
		for(String name:hashSet)
			System.out.println(name);
		
		
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("poppy");
		linkedHashSet.add("sam");
		linkedHashSet.add("rusty");
		linkedHashSet.add("100");
		
		linkedHashSet.add(null);
		
		System.out.println(linkedHashSet);
		
		System.out.println("using iterator on linked hash set");
		for(String name:linkedHashSet)
			System.out.println(name);
		
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("poppy");
		treeSet.add("sam");
		treeSet.add("rusty");
		treeSet.add("100");
		
		treeSet.add(null);
		
		System.out.println(treeSet);
		
		System.out.println("using iterator on linked hash set");
		for(String name:treeSet)
			System.out.println(name);
	}

}
