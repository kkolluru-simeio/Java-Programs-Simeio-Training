package com.simeio.serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerialDemo {
	
	public static void main(String[] args) {
		Student student = new Student("Ram", "CSE", 20);
		try(FileOutputStream fileOutputStream = new FileOutputStream("demo.txt");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
			objectOutputStream.writeObject(student);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
