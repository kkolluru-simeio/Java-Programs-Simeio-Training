package com.simeio.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("mrs.boot");
		list.addFirst("poppy");
		list.addLast("rusty");
		list.add("sam");
		list.add(2, "ted");
		list.add(null);
		list.add(null);
		list.offer("peppa");
		
		
		System.out.println("Elements added so far" + list);
		System.out.println(list.poll());
		
		System.out.println("Element at pos 3 " + list.get(2));
		
		list.set(0, "kiran");
		
		list.removeFirst();
		
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
		
		int size = 2;
		 
      
		
		
		  LinkedList<Dev> list1 = new LinkedList<>(); Emp emp = new Dev();
		  list1.add((Dev)emp); emp = new Mgr();
		  System.out.println(list1.offer((Dev)emp));
		 
		
	}

}

class Emp {
	String name;
}

class Dev extends Emp {
	
}

class Mgr extends Emp {
	
}


