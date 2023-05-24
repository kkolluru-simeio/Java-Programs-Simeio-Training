package com.groupon.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.groupon.model.Voucher;
import com.groupon.util.VouchersList;

public class VoucherServiceImpl implements IVoucherService {

	@Override
	public List<Voucher> getAllVouchers() {
		
		return VouchersList.getVouchersList();
	}

	@Override
	public List<Voucher> getVouchersByOutletLocation(List<Voucher> voucherList, String location) {

		return voucherList.stream().filter(voucher -> voucher.getOutletLocation().equals(location)).collect(Collectors.toList());

	}

	@Override
	public Optional<Voucher> getVoucherById(List<Voucher> voucherList, int voucherId) {
		return voucherList.stream().filter(voucher -> voucher.getVoucherId() == voucherId).findFirst();

	}

	@Override
	public List<Voucher> getVouchersByCategory(List<Voucher> voucherList, String category) {
		return voucherList.stream().filter(voucher -> voucher.getCategory().equals(category)).collect(Collectors.toList());

	}

	@Override
	public List<Voucher> getVouchersByOutletName(List<Voucher> voucherList, String outletName) {
		return voucherList.stream().filter(voucher -> voucher.getOutletName().equals(outletName)).collect(Collectors.toList());

	}
	
	@Override
	public List<Voucher> getVouchersByCity(List<Voucher> voucherList, String city) {
		return voucherList.stream().filter(voucher -> voucher.getCity().equals(city)).collect(Collectors.toList());

	}

	@Override
	public List<Voucher> getVouchersByDiscountPercent(List<Voucher> voucherList) {
		return voucherList.stream().sorted((o1,o2) -> o1.getDiscountPercent().compareTo(o2.getDiscountPercent())).collect(Collectors.toList());

	}
	
	@Override
	public List<Voucher> getVouchersByDiscountPercentDesc(List<Voucher> voucherList) {
		return voucherList.stream().sorted((o1,o2) -> o2.getDiscountPercent().compareTo(o1.getDiscountPercent())).collect(Collectors.toList());

	}

	@Override
	public List<Voucher> getVouchersByExpiryDate(List<Voucher> voucherList) {

		return voucherList.stream().sorted((o1,o2) -> o1.getExpiryDate().compareTo(o2.getExpiryDate())).collect(Collectors.toList());

	}

	@Override
	public List<Voucher> getVouchersByMaxDiscount(List<Voucher> voucherList) {
		
		return voucherList.stream().sorted((o1,o2) -> o1.getMaxDiscount().compareTo(o2.getMaxDiscount())).collect(Collectors.toList());

	}


	@Override
	public List<Voucher> getVouchersByMaxDiscountDesc(List<Voucher> voucherList) {
		return voucherList.stream().sorted((o1,o2) -> o2.getMaxDiscount().compareTo(o1.getMaxDiscount())).collect(Collectors.toList());


	}


}
