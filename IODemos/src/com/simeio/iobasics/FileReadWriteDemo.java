package com.simeio.iobasics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileOutputStream;

public class FileReadWriteDemo {

	public static void main(String[] args) {

		char ch = 0;

		FileOutputStream fileOutputStream = null;

		try {
			FileInputStream fileInputStream = new FileInputStream("demo.txt");
			fileOutputStream = new FileOutputStream("demo2.txt");

			byte[] bytes = fileInputStream.readAllBytes();

			fileOutputStream.write(bytes);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null)
					fileOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			FileInputStream fileInputStream = new FileInputStream("demo.txt");
			fileOutputStream = new FileOutputStream("demo3.txt", true);
			char chr;
			int i;
			while((i = fileInputStream.read()) !=-1)
			{
				chr = (char)i;
				fileOutputStream.write(chr);
			}
			
		}
		 catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fileOutputStream != null)
						fileOutputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
}
