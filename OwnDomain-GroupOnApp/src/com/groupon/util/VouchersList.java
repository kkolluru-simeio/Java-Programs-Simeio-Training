package com.groupon.util;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.groupon.model.Voucher;

public class VouchersList {
	
	public static List<Voucher> getVouchersList() {
		return Arrays.asList(
		 new Voucher(1,"Dominos", "BTM", "bglr" , 10, new Date(2023,6,30), 500.00, 200.00, "food"),
		 new Voucher(2,"Dominos", "DLF", "hyd", 15, new Date(2023,5,31), 1000.00, 300.00,  "food"),
		 new Voucher(3,"VLCC", "BTM",  "bglr" ,20, new Date(2023,6,10), 2000.00, 500.00, "salon"),
		 new Voucher(4,"GreenTrends", "MHPR",  "bglr" , 5, new Date(2023,12,31), 1000.00,200.00, "salon"),
		 new Voucher(5,"pvr", "MG road",  "hyd" , 10, new Date(2023,8,30), 500.00, 100.00,"movies"),
		 new Voucher(6,"Trends", "Hoodi",  "bglr" ,30, new Date(2023,7,31), 1000.00, 1000.00, "clothing"),
		 new Voucher(7,"imax", "Whitefield", "bglr" , 5, new Date(2023,6,30), 500.00, 200.00, "movies"),
		 new Voucher(8,"life style", "Marathahalli", "bglr" , 10, new Date(2024,5,31), 2000.00,500.00, "clothing"),
		 new Voucher(9,"Mc Donald", "MG road",  "bglr" ,10, new Date(2023,11,30), 500.00, 100.00, "food"),
		 new Voucher(10,"Biryani House", "Marathahalli",  "bglr" ,15, new Date(2023,5,31), 1000.00, 300.00, "food"));

		 
	}

}
