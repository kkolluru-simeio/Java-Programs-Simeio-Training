package com.groupon.service;

import java.util.List;
import java.util.Optional;

import com.groupon.model.Voucher;

public interface IVoucherService {
	
	List<Voucher> getAllVouchers();

	List<Voucher> getVouchersByOutletLocation(List<Voucher> voucherList, String location);
	
	Optional<Voucher> getVoucherById(List<Voucher> voucherList, int voucherId);
	
	List<Voucher> getVouchersByCategory(List<Voucher> voucherList, String category);
	
	List<Voucher> getVouchersByOutletName(List<Voucher> voucherList, String outletName);
	
	List<Voucher> getVouchersByCity(List<Voucher> voucherList, String city);
	
	List<Voucher> getVouchersByDiscountPercent(List<Voucher> voucherList);
	
	List<Voucher> getVouchersByDiscountPercentDesc(List<Voucher> voucherList);
	
	List<Voucher> getVouchersByExpiryDate(List<Voucher> voucherList);
	
	List<Voucher> getVouchersByMaxDiscount(List<Voucher> voucherList);
	
	List<Voucher> getVouchersByMaxDiscountDesc(List<Voucher> voucherList);
	
	

}
