package com.simeio.FunctionalInterface;

interface ICompressor {
	void compressFile(String fname);
}

class Converter {
	
	void convertFile(String fname, ICompressor icom, String type) {
		System.out.println("Converting file " + fname);
		icom.compressFile(fname);
		System.out.println("File conversion completed");
	}
}

public class FileConverter {
	 
	public static void main(String[] args) {
		
		Converter converter = new Converter();
		ICompressor icom = (fname) -> System.out.println("Conmpressing file to zip "+ fname);
		converter.convertFile("file1.txt", icom, "txt");
		
	}

}
