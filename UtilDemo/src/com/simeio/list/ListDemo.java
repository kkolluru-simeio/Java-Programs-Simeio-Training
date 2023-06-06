package com.simeio.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("kirnan");
		list.add("poppy");
		list.add("sam");
		System.out.println("Elements added so far" + list);
		
		System.out.println("Element at pos 3 " + list.get(2));
		
		list.set(0, "kiran");
		list.add("rusty");
		
		list.add("ted");
		
		Collections.sort(list);
		
		System.out.println("Using iterator");
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		// Returns a list iterator over the elements in this list (in propersequence), 
		//starting at the specified position in the list.
		//The specified index indicates the first element that would bereturned by an initial call to next.
		//An initial call to previous wouldreturn the element with the specified index minus one.
		System.out.println("Using List iterator");
		ListIterator<String> li = list.listIterator(list.size());
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
		
	}

}
