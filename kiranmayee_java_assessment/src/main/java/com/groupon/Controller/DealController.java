package com.groupon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.model.Deal;
import com.groupon.service.IDealService;

@RestController
@RequestMapping("/deal-api")
public class DealController {

	@Autowired
	IDealService dealService;

	@PostMapping("/deals")
	ResponseEntity<Void> addDeal(@RequestBody Deal deal) {
		//System.out.println("Received info" + deal.getExpiryDate());
		dealService.addDeal(deal);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "deal added to db");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	}
	
	@PutMapping("/deals")
	ResponseEntity<Void>  updateDeal(@RequestBody Deal deal) {
		dealService.updateDeal(deal);
		return ResponseEntity.accepted().build();
		
	}

	@DeleteMapping("/deals/dealId/{dealId}")
	ResponseEntity<Void> deleteDeal(@PathVariable("dealId") int dealId) {
		dealService.deleteDeal(dealId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/deals")
	ResponseEntity<List<Deal>> getAllDeals() {
		System.out.println("getting all the deals");
		List<Deal> dealList = dealService.getAllDeals();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all deals");
		headers.add("desc", "deals in the database");
		ResponseEntity<List<Deal>> responseEntity = new ResponseEntity<List<Deal>>(dealList, headers, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/deals/dealId/{dealId}")
	ResponseEntity<Deal>  getById(@PathVariable("dealId") int dealId) {
		Deal deal = dealService.getDealById(dealId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning deal by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(deal);
	}
	
	@GetMapping("/deals/category/{category}")
	ResponseEntity<List<Deal>>  getDealsByCategory(@PathVariable("category") String category) {
		List<Deal> dealList = dealService.getDealsByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning deals by category");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(dealList);
	}
	
	@GetMapping("/deals/discountedPrice")
	ResponseEntity<List<Deal>>  getDealsByDiscountedPrice() {
		List<Deal> dealList = dealService.getDealsByDiscountedPrice();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning deals by discounted price");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(dealList);
	}
	
	@GetMapping("/deals/expiryDate")
	ResponseEntity<List<Deal>>  getDealsByExpiryDate() {
		List<Deal> dealList = dealService.getDealsByExpiryDate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning deals ordered by shortest expiry");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(dealList);
	}
	
	@GetMapping("/deals/noOfPurchases")
	ResponseEntity<List<Deal>>  getDealsByNoOfPurchases() {
		List<Deal> dealList = dealService.getDealsByNoOfPurchases();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning deals ordered by shortest expiry");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(dealList);
	}
	
	
}