package com.simeio.iobasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResources {
	public static void main(String[] args) {
		
	try(FileInputStream fileInputStream = new FileInputStream("demo.txt");
			FileOutputStream fileOutputStream = new FileOutputStream("demo3.txt", true);) {
		char chr;
		int i;
		while((i = fileInputStream.read()) !=-1)
		{
			chr = (char)i;
			fileOutputStream.write(chr);
		}
	}
	catch(FileNotFoundException ex) {
		ex.printStackTrace();
	}
	catch(IOException ex) {
		ex.printStackTrace();
	}
	}
}
