package com.bookapp.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.BookDTO;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class CsvHelper {
	
	public List<BookDTO> csvToList(String fileName) {

			List<BookDTO> bookDTOList  = new ArrayList<>();
		try(FileReader reader = new FileReader(fileName);) {
			bookDTOList=  new CsvToBeanBuilder<BookDTO>(reader).withType(BookDTO.class).build().parse();

		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return bookDTOList;
		
	}

}
