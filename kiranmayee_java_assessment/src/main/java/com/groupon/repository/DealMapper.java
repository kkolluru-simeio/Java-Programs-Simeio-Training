package com.groupon.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.groupon.model.Deal;

public class DealMapper implements RowMapper<Deal>{

	@Override
	public Deal mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Deal deal = new Deal();
		 deal.setDealId(rs.getInt("dealId"));
		 deal.setOutletId(rs.getInt("outletId"));
		 deal.setCategory(rs.getString("category"));
		 deal.setDiscountedPrice(rs.getDouble("discountedPrice"));
		 deal.setOriginalPrice(rs.getDouble("originalPrice"));
		 deal.setExpiryDate(rs.getTimestamp("expiryDate").toLocalDateTime());
		 deal.setNoOfPurchases(rs.getInt("noOfPurchases"));
		
		return deal;
		
	}

}
