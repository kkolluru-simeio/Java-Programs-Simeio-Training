package com.groupon.main;

import java.util.List;
import java.util.Optional;

import com.groupon.model.Voucher;
import com.groupon.service.IVoucherService;
import com.groupon.service.VoucherServiceImpl;

public class Client {

	public static void main(String[] args) {

		IVoucherService voucherService = new VoucherServiceImpl();
		List<Voucher> vouchers = voucherService.getAllVouchers();
		System.out.println("printing all vouchers");
		for (Voucher voucher : vouchers)
			System.out.println(voucher);
		System.out.println();

		System.out.println("getting all vouchers by location");
		List<Voucher> filteredVouchers = voucherService.getVouchersByCity(vouchers, "bglr"); 
		filteredVouchers =	voucherService.getVouchersByOutletLocation(filteredVouchers, "MG road");
		for (Voucher voucher : filteredVouchers)
			System.out.println(voucher);
		System.out.println();

		System.out.println("getting vouchers by id");
		Optional<Voucher> voucherById = voucherService.getVoucherById(vouchers, 5);
		System.out.println(voucherById);
		System.out.println();

		System.out.println("getting all vouchers by category");
		filteredVouchers = voucherService.getVouchersByCategory(vouchers, "clothing");
		for (Voucher voucher : filteredVouchers)
			System.out.println(voucher);
		System.out.println();

		System.out.println("getting all vouchers by outlet name");
		filteredVouchers = voucherService.getVouchersByOutletName(vouchers, "Dominos");
		for (Voucher voucher : filteredVouchers)
			System.out.println(voucher);
		System.out.println();

		System.out.println("getting all vouchers by expiry date");
		filteredVouchers = voucherService.getVouchersByExpiryDate(vouchers);
		for (Voucher voucher : filteredVouchers)
			System.out.println(voucher);
		System.out.println();
		
		System.out.println("getting all vouchers by category and sort by max discount desc");
		filteredVouchers = voucherService.getVouchersByCategory(vouchers, "food");
		filteredVouchers = voucherService.getVouchersByMaxDiscountDesc(filteredVouchers);
		for (Voucher voucher : filteredVouchers)
			System.out.println(voucher);
		
		

	}

}
