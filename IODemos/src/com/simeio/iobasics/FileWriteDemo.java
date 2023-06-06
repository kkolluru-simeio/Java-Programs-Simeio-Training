package com.simeio.iobasics;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriteDemo {

	public static void main(String[] args) {

		InputStreamReader isReader = new InputStreamReader(System.in);

		BufferedReader bufferedReader = new BufferedReader(isReader);

		char ch = 0;
		
		FileOutputStream fileOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream("demo.txt");
			ch = (char) bufferedReader.read();

			while (ch != 'q') {
				fileOutputStream.write(ch);
				ch = (char) bufferedReader.read();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fileOutputStream != null)
					fileOutputStream.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
